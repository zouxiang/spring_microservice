package com.nokia.code.springcloud.licenses.events.handlers;

import com.nokia.code.springcloud.licenses.events.channels.CustomChannels;
import com.nokia.code.springcloud.licenses.events.models.OrganizationChangeModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(CustomChannels.class)
public class OrganizationChangeHandler {
    private static final Logger logger = LoggerFactory.getLogger(OrganizationChangeHandler.class);

    @StreamListener("inboundOrgChanges")
    public void loggerSink(OrganizationChangeModel orgChange) {
        logger.info("OrganizationChangeHandler： Received an event for organization id is {}, action is {}, type is {}",
                orgChange.getOrganizationId(),
                orgChange.getAction(),
                orgChange.getType());
    }
}
