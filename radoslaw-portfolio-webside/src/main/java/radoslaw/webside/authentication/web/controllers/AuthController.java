package radoslaw.webside.authentication.web.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import radoslaw.webside.authentication.core.models.User;
import radoslaw.webside.authentication.core.services.UserService;
import radoslaw.webside.authentication.web.dtos.UserLoginDTO;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginDTO userLoginDTO){
        return userService.authUser(userLoginDTO.getEmail(), userLoginDTO.getPassword());
    }

    @PostMapping(path = "/register")
    public ResponseEntity<?> createUser(@Valid @RequestBody User user, BindingResult validationResult) throws BindException {
         return userService.createUser(user,validationResult);
    }
}
