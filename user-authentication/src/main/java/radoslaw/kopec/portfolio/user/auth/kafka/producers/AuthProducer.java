package radoslaw.kopec.portfolio.user.auth.kafka.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AuthProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendResponse(String topic, String response) {
        kafkaTemplate.send(topic, response);
    }
}
