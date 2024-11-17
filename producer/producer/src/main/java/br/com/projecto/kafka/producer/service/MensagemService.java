package br.com.projecto.kafka.producer.service;

import lombok.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MensagemService {

    private static final Logger logger = LoggerFactory.getLogger(MensagemService.class);

    private String topicAprendendoKafka;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        logger.info("Mensagem -> {}", message);
        this.kafkaTemplate.send(topicAprendendoKafka, message);
    }

    public void setTopicAprendendoKafka(String topicAprendendoKafka) {
        this.topicAprendendoKafka = topicAprendendoKafka;
    }
}
