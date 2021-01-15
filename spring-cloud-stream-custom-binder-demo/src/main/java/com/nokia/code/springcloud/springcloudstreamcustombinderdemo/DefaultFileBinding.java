package com.nokia.code.springcloud.springcloudstreamcustombinderdemo;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableBinding({Source.class, Sink.class})
public class DefaultFileBinding {
    @StreamListener(Sink.INPUT)
    @SendTo(Source.OUTPUT)
    public String handle(String message) {
        return String.format("Received: %s", message);
    }

}
