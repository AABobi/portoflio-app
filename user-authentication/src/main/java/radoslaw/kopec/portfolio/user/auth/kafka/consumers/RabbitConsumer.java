package radoslaw.kopec.portfolio.user.auth.kafka.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import radoslaw.kopec.portfolio.user.auth.users.web.dtos.ResponseMessage;

@Service
public class RabbitConsumer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "request_queue")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);

        String responseMessage = "Processed: " + message;
        ResponseMessage responseMessage1 = new ResponseMessage();
        responseMessage1.setBody(message);
        responseMessage1.setStatus(HttpStatus.OK);
        System.out.println("test");
        rabbitTemplate.convertAndSend("response_queue", responseMessage1);
    }
}
