package radoslaw.kopec.portfolio.user.auth.users.web.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
public class ResponseMessage {

    private String body;
    private HttpStatus status;
    private Map<String, String> headers;
}
