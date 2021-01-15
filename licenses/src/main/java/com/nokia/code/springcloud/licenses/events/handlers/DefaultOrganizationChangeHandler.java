package com.nokia.code.springcloud.licenses.events.handlers;

import com.nokia.code.springcloud.licenses.events.models.OrganizationChangeModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class DefaultOrganizationChangeHandler {
    private static final Logger logger = LoggerFactory.getLogger(DefaultOrganizationChangeHandler.class);

    @StreamListener(Sink.INPUT)
    public void loggerSink(OrganizationChangeModel orgChange) {
        logger.info("DefaultOrganizationChangeHandler： Received an event for organization id is {}, action is {}, type is {}",
                orgChange.getOrganizationId(),
                orgChange.getAction(),
                orgChange.getType());
    }
}
