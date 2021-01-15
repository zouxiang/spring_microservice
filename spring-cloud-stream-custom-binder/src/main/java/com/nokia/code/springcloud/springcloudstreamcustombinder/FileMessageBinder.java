package com.nokia.code.springcloud.springcloudstreamcustombinder;

import com.nokia.code.springcloud.springcloudstreamcustombinder.producers.FileMessageProducer;
import com.nokia.code.springcloud.springcloudstreamcustombinder.provisioners.FileMessageBinderProvisioner;
import org.springframework.cloud.stream.binder.AbstractMessageChannelBinder;
import org.springframework.cloud.stream.binder.ConsumerProperties;
import org.springframework.cloud.stream.binder.ProducerProperties;
import org.springframework.cloud.stream.provisioning.ConsumerDestination;
import org.springframework.cloud.stream.provisioning.ProducerDestination;
import org.springframework.integration.core.MessageProducer;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.OffsetDateTime;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class FileMessageBinder extends AbstractMessageChannelBinder<ConsumerProperties, ProducerProperties, FileMessageBinderProvisioner> {
    public FileMessageBinder(String[] headersToEmbed, FileMessageBinderProvisioner provisioningProvider) {
        super(headersToEmbed, provisioningProvider);
    }

    @Override
    protected MessageHandler createProducerMessageHandler(
            ProducerDestination destination,
            ProducerProperties producerProperties,
            MessageChannel errorChannel) throws Exception {
        return message -> {
            String fileName = destination.getName();
            String payload = new String((byte[])message.getPayload()) + ". Updated in destination " + fileName + " at " + OffsetDateTime.now().toString() + "\n";
            try {
                Files.write(Paths.get(fileName), payload.getBytes(), CREATE, APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    @Override
    protected MessageProducer createConsumerEndpoint(
            ConsumerDestination destination,
            String group,
            ConsumerProperties properties) throws Exception {
        return new FileMessageProducer(destination);
    }
}
