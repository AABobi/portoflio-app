package radoslaw.kopec.portfolio.api_gateway.authentication.core.services;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import radoslaw.kopec.portfolio.api_gateway.authentication.web.dtos.ResponseMessage;
import radoslaw.kopec.portfolio.api_gateway.rabbit_config.RabbitMQConfig;

import java.util.Objects;

@Service
public class MessageListenerService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public ResponseEntity<String> sendMessageAndWaitForResponse(String jsonMessage) {
        try {
            var response =  rabbitTemplate.convertSendAndReceive(
                    RabbitMQConfig.EXCHANGE, RabbitMQConfig.REQUEST_QUEUE, jsonMessage);
            if (response == null) {
                return new ResponseEntity<>("Auth response error1", HttpStatus.INTERNAL_SERVER_ERROR);
            }
            System.out.println("TEST");
            System.out.println(response);
            return new ResponseEntity<>(response.toString(),HttpStatus.OK);
        } catch (AmqpException e) {
            return new ResponseEntity<>("Auth response error2", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
