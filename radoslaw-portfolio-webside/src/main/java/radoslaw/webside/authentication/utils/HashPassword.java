package radoslaw.webside.authentication.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;


public class HashPassword {

    /**
     * Generates a cryptographically secure 512 bytes string that can be used as a password salt
     */
    public static String generateHashPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    /**
     * Generate a hash for a password
     */
    public static boolean validatePassword(String password, String hashedPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(password,hashedPassword);
    }
}
