package radoslaw.webside.authentication.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.server.ResponseStatusException;
import radoslaw.webside.authentication.core.models.User;
import radoslaw.webside.authentication.core.models.enums.Roles;
import radoslaw.webside.authentication.core.repositories.RoleRepository;
import radoslaw.webside.authentication.core.repositories.UserRepository;
import radoslaw.webside.authentication.utils.HashPassword;
import radoslaw.webside.authentication.utils.JwtUtil;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public ResponseEntity<String> authUser(String email, String password) {
        var user = userRepository.findUserByEmail(email);
        return user.map(value -> {
                boolean isPasswordValid = HashPassword.validatePassword(password, value.getPassword());
                if(!isPasswordValid) {
                    return new ResponseEntity<>("Password doesn't match",HttpStatus.UNAUTHORIZED);
                }

                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.add("token",JwtUtil.generateToken(value.getEmail()));
                return new ResponseEntity<>("Login succeed",httpHeaders,HttpStatus.OK);
        })
                .orElseGet(() -> new ResponseEntity<>("Email or password doesn't match", HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<String> createUser(User user, BindingResult bindingResult) throws BindException {
        if(bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        }
        userRepository.findUserByEmail(user.getEmail())
                .or(() -> userRepository.findUserByName(user.getName()))
                .ifPresent(existingUser -> {
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Email or name is already taken");
        });

        return roleRepository.findByRole(Roles.USER)
                .map(role -> {
                    user.setRole(role);
                    user.setPassword(HashPassword.generateHashPassword(user.getPassword()));
                    userRepository.save(user);
                    return new ResponseEntity<>("User created", HttpStatus.CREATED);
                })
                .orElseThrow(() -> new IllegalArgumentException("Role USER not found"));
    }
}
