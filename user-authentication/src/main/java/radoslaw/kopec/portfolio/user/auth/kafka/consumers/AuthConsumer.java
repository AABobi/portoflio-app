package radoslaw.kopec.portfolio.user.auth.kafka.consumers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import radoslaw.kopec.portfolio.user.auth.kafka.producers.AuthProducer;
import radoslaw.kopec.portfolio.user.auth.users.core.service.UserService;

@Service
public class AuthConsumer {

    @Autowired
    private AuthProducer authProducer;

    @Autowired
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    private static final String TOPIC = "topicB";
    private static final String AUTH_LOGIN_ATTEMPTS_RESPONSE = "auth-login-attempts-response";

    @KafkaListener(topics = "topicA", groupId = "group-id")
    public void listenFromKafka(String message) {
        var a = userService.findAllUsers();
        authProducer.sendResponse("topicB", message);
    }

    @KafkaListener(topics = "auth-login-attempts", groupId = "auth-login-attempts-group")
    public void authLoginAttempts(String message) throws JsonProcessingException {
        var serviceResponse = userService.authenticateUser(message);
        System.out.println(message);

        authProducer.sendResponse(AUTH_LOGIN_ATTEMPTS_RESPONSE, serviceResponse);
    }
}