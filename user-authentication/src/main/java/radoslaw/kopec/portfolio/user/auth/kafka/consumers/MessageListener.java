package radoslaw.kopec.portfolio.user.auth.kafka.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import radoslaw.kopec.portfolio.user.auth.users.web.dtos.ResponseMessage;

@Service
public class MessageListener {

 /*   @RabbitListener(queues = RabbitMQConfig.REQUEST_QUEUE)
    public String handleMessage(String jsonMessage) {
        // Process the JSON message
        System.out.println("Received message: " + jsonMessage);

        // Create and return a response
        String responseMessage = "Processed message1: " + jsonMessage;
        return responseMessage;
    }*/
 @RabbitListener(queues = RabbitMQConfig.REQUEST_QUEUE)
 public ResponseMessage handleMessage(String jsonMessage) {
     System.out.println("Received message: " + jsonMessage);
     ResponseMessage responseMessage = new ResponseMessage();
     responseMessage.setBody("Processed message: " + jsonMessage);
     responseMessage.setStatus(HttpStatus.OK);
     return responseMessage;
 }
}