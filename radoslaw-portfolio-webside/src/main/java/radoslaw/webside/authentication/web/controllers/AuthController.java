package radoslaw.webside.authentication.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import radoslaw.webside.authentication.core.models.User;
import radoslaw.webside.authentication.core.services.UserService;
import radoslaw.webside.authentication.utils.HashPassword;
import radoslaw.webside.authentication.web.dtos.UserLoginDTO;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginDTO userLoginDTO){
        return userService.authUser(userLoginDTO.getEmail());
    }

    @PostMapping(path = "/register")
    public ResponseEntity<?> createUser(@RequestBody UserLoginDTO userLoginDTO){
        return userService.authUser(userLoginDTO.getEmail());
    }

    @GetMapping(path = "/test1")
    public String test1() {
        return "aa";
    }

    @GetMapping(path = "/test11")
    public String test11() {
        return "aa12";
    }
}
