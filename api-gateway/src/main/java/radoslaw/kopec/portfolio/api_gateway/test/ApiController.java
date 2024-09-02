package radoslaw.kopec.portfolio.api_gateway.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    private ServiceAListener serviceAListener;

    private static final String TOPIC = "topicA";

    @PostMapping("/kafka")
    public ResponseEntity<String> sendMessageToKafka(@RequestBody String message) {
        System.out.println("test2");
        kafkaTemplate.send(TOPIC, message);
        String response = serviceAListener.waitForResponse();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody String message) {
        System.out.println("test");
        System.out.println(message);
        kafkaTemplate.send("auth-login-attempts", message);
        String response = serviceAListener.waitForResponse();
        return ResponseEntity.ok(response);
    }
}
