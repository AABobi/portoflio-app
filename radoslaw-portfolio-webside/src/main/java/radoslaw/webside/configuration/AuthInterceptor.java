package radoslaw.webside.configuration;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import radoslaw.webside.authentication.utils.JwtUtil;

import java.util.Date;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    private String secretKey = "your-secret-key";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Extract the Authorization header
        String authToken = request.getHeader("Authorization");
        var a = request.getHeaderNames();

        // Perform token validation (custom logic for token validation)
        var email = JwtUtil.validateToken(authToken).getSubject();

        if (authToken != null && JwtUtil.isTokenValid(authToken,email)) {
            return true; // Continue to the endpoint if the token is valid
        }

        // If the token is invalid or missing, block the request and send a 401 Unauthorized response
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        return false; // Prevents the request from reaching the controller
    }

    private boolean validateToken(String token) {
        System.out.println("TEST AUTH");
        return true;
    }
}