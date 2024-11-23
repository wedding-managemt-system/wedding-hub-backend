package org.example.order.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.example.base.dto.OrderEventDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderEventDTO.class);

//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;

    private final NewTopic orderTopic;

//    create kafka template
    private final KafkaTemplate<String, OrderEventDTO> kafkaTemplate;

    public OrderProducer(KafkaTemplate<String, OrderEventDTO> kafkaTemplate, NewTopic orderTopic) {
        this.kafkaTemplate = kafkaTemplate;
        this.orderTopic = orderTopic;
    }

    public void sendMessage(OrderEventDTO orderEventDTO) {
        LOGGER.info(String.format("sending order event to topic %s" , orderEventDTO.toString()));

        Message<OrderEventDTO> message = MessageBuilder
                .withPayload(orderEventDTO)
                .setHeader(KafkaHeaders.TOPIC , orderTopic.name())
                .build();

        kafkaTemplate.send(message);
    }

}
