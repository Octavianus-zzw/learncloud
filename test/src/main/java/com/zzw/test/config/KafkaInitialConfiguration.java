package com.zzw.test.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaInitialConfiguration {
    @Bean
    public NewTopic initialTopic() {
        return new NewTopic("testtopic", 2, (short) 1);
    }

    @Bean
    public NewTopic updateTopic() {
        return new NewTopic("testtopic", 2, (short) 1);
    }
}
