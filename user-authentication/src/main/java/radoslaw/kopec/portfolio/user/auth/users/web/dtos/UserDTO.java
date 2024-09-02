package radoslaw.kopec.portfolio.user.auth.users.web.dtos;

import lombok.*;
import org.springframework.stereotype.Component;
import radoslaw.kopec.portfolio.user.auth.users.core.models.User;
import radoslaw.kopec.portfolio.user.auth.users.core.models.enums.Roles;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Component
public class UserDTO {

    private String email;
    private Roles role;

    public void createUserDTO(User user) {
        this.email = user.getEmail();
        this.role = user.getRole().getRole();
    }
}
