package radoslaw.webside.authentication.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import radoslaw.webside.authentication.core.models.Role;
import radoslaw.webside.authentication.core.models.User;
import radoslaw.webside.authentication.core.models.enums.Roles;
import radoslaw.webside.authentication.core.repositories.RoleRepository;
import radoslaw.webside.authentication.core.repositories.UserRepository;
import radoslaw.webside.authentication.utils.HashPassword;
import radoslaw.webside.authentication.utils.JwtUtil;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

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

    public ResponseEntity<String> createUser(@RequestBody User user){
        var isUserExist = userRepository.findUserByEmail(user.getEmail()).isPresent();

        if(isUserExist) {
            return new ResponseEntity<>("User already exist",HttpStatus.CONFLICT);
        }
        var role = roleRepository.findByRole(Roles.USER);

        if(role.isPresent()) {
            user.setRole(role.get());
            user.setPassword(HashPassword.generateHashPassword(user.getPassword()));
            userRepository.save(user);
            return new ResponseEntity<>("User created", HttpStatus.CREATED);
        } else {
            throw new IllegalArgumentException("Role USER not found");
        }
    }
}
