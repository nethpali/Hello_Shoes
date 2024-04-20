package lk.com.ijse.hello_shoes_test.reqsAndres.Secure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SignIn {
    private String email;
    private String password;
}
