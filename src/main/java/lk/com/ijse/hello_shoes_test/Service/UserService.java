package lk.com.ijse.hello_shoes_test.Service;

import lk.com.ijse.hello_shoes_test.DTO.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    UserDetailsService userDetailsService();
    void save(UserDto user);
}
