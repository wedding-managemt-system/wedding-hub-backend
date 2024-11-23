package org.example.order.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class kafkaTopicConfig {

    @Value("${spring.kafka.template.default-topic}")   // this one like as a getting things in .env file
    private String topicName;

    @Bean
    public NewTopic createTopic(){
        return TopicBuilder.name(topicName).partitions(1).replicas(1).build();
    }

}
