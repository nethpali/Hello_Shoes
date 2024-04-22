package lk.com.ijse.hello_shoes_test.reqsAndres.Secure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignUp {
    private String email;
    private String password;
    private String role;
}
