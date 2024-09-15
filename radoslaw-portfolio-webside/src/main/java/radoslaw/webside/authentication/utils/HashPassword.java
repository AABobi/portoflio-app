package radoslaw.webside.authentication.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;

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
    public static void validatePassword(String password, String hashedPassword) throws NoSuchAlgorithmException, InvalidKeySpecException {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        passwordEncoder.matches(password,hashedPassword);
    }
}
