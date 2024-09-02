package radoslaw.kopec.portfolio.user.auth.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {

    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static String generateToken(String value) {
        return Jwts.builder()
                .setSubject(value)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 h
                .signWith(key)
                .compact();
    }

    // Weryfikacja i parsowanie JWT
    public static Claims validateToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // Sprawdzanie, czy token jest ważny
    public static boolean isTokenValid(String token, String username) {
        final String tokenUsername = getUsernameFromToken(token);
        return (tokenUsername.equals(username) && !isTokenExpired(token));
    }

    // Pobieranie nazwy użytkownika z tokenu
    public static String getUsernameFromToken(String token) {
        return validateToken(token).getSubject();
    }

    // Sprawdzanie, czy token wygasł
    public static boolean isTokenExpired(String token) {
        return validateToken(token).getExpiration().before(new Date());
    }
}
