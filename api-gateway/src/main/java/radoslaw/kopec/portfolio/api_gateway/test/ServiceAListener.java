package radoslaw.kopec.portfolio.api_gateway.test;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

@Service
public class ServiceAListener {

    private CountDownLatch latch = new CountDownLatch(1);
    private String response;

    @KafkaListener(topics = "topicB", groupId = "group-id")
    public void listenFromKafka(String message) {
        this.response = message;
        latch.countDown();
    }

    @KafkaListener(topics = "auth-login-attempts-response", groupId = "auth-login-attempts-group")
    public void listen(String message) {
        System.out.println("aauth-login-attempts-group");
        this.response = message;
        latch.countDown();
    }

    public String waitForResponse() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return response;
    }
}