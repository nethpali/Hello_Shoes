package lk.com.ijse.hello_shoes_test.DTO;

import lk.com.ijse.hello_shoes_test.Entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDto {
    private String userId;
    private String email;
    private String password;
    private Role role;
}
