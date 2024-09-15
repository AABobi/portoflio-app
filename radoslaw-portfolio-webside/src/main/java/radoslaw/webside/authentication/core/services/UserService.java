package radoslaw.webside.authentication.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import radoslaw.webside.authentication.core.repositories.UserRepository;
import radoslaw.webside.authentication.utils.JwtUtil;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public ResponseEntity<String> authUser(String email) {
        var user = userRepository.findUserByEmail(email);
        return user.map(value -> {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.add("token",JwtUtil.generateToken(value.getEmail()));
                return new ResponseEntity<>("Login succeed",httpHeaders,HttpStatus.OK);
        })
                .orElseGet(() -> new ResponseEntity<>("Email or password doesn't match", HttpStatus.NOT_FOUND));
    }
}
