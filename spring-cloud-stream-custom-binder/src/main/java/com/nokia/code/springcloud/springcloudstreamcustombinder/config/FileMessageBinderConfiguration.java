package com.nokia.code.springcloud.springcloudstreamcustombinder.config;

import com.nokia.code.springcloud.springcloudstreamcustombinder.FileMessageBinder;
import com.nokia.code.springcloud.springcloudstreamcustombinder.provisioners.FileMessageBinderProvisioner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileMessageBinderConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public FileMessageBinderProvisioner fileMessageBinderProvisioner() {
        return new FileMessageBinderProvisioner();
    }

    @Bean
    @ConditionalOnMissingBean
    public FileMessageBinder fileMessageBinder(FileMessageBinderProvisioner fileMessageBinderProvisioner) {
        return new FileMessageBinder(null, fileMessageBinderProvisioner);
    }
}
