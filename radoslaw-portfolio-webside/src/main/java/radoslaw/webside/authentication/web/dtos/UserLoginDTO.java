package radoslaw.webside.authentication.web.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserLoginDTO {

    private String email;
    private String password;
}
