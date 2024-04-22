package lk.com.ijse.hello_shoes_test.Service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {
    String extractUserName(String token);
    String generateToken(UserDetails userDetails);
    boolean isValidateToken(String token , UserDetails userDetails);
}
