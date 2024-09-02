package radoslaw.kopec.portfolio.user.auth.users.web.response;

import jakarta.annotation.PreDestroy;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@NoArgsConstructor
@Component
public class AuthResponse {

    private String token;
    private String message;
}
