package radoslaw.kopec.portfolio.user.auth.users.core.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import radoslaw.kopec.portfolio.user.auth.users.core.models.User;
import radoslaw.kopec.portfolio.user.auth.users.core.persistence.repositories.UserRepository;
import radoslaw.kopec.portfolio.user.auth.users.web.dtos.UserDTO;
import radoslaw.kopec.portfolio.user.auth.users.web.dtos.UserLoginRequest;
import radoslaw.kopec.portfolio.user.auth.utils.JwtUtil;

import java.util.List;
import java.util.NoSuchElementException;

import static radoslaw.kopec.portfolio.user.auth.utils.JsonReader.readJsonValue;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDTO userDTO;

    @Autowired
    private ObjectMapper objectMapper;
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public String authenticateUser(String message) throws NoSuchElementException {
        try {
            var userLoginRequest = readJsonValue(message,UserLoginRequest.class);
            var user = userRepository.findByEmail(userLoginRequest.email()).orElseThrow( () -> new NoSuchElementException("User is not found"));
            userDTO.createUserDTO(user);
            return JwtUtil.generateToken(userDTO.getEmail());
        } catch (RuntimeException e){
            return e.getMessage();
        }
    }
}
