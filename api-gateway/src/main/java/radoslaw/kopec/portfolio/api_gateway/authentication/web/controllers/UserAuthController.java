package radoslaw.kopec.portfolio.api_gateway.authentication.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import radoslaw.kopec.portfolio.api_gateway.authentication.core.services.MessageListenerService;

@RestController
@RequestMapping("/api")
public class UserAuthController {

    @Autowired
    private MessageListenerService messagingService;

    @PostMapping("/call-service")
    public ResponseEntity<String> callService(@RequestBody String jsonMessage) {
        var response = messagingService.sendMessageAndWaitForResponse(jsonMessage);
        if (response == null) {
            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body("No response from service 2");
        }
        return response;
    }

/*
    @PostMapping("/authentication-attempt")
    public ResponseEntity<String> authenticationAttempt(@RequestBody String loginData) {
        try {
            return messagingService.sendMessageAndWaitForResponse(loginData);

        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }
*/

 /*   private requestHandler(String response) {
        return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body("No response from service 2");
    }*/
}

