package radoslaw.kopec.portfolio.user.auth.users.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import radoslaw.kopec.portfolio.user.auth.users.core.service.UserService;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;
    private static final String AUTH_LOGIN_ATTEMPTS_RESPONSE = "auth-login-attempts-response";

    public void authLoginAttempts(String request) {


    }
}
