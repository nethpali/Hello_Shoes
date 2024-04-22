package lk.com.ijse.hello_shoes_test.Service;

import lk.com.ijse.hello_shoes_test.reqsAndres.Secure.SignIn;
import lk.com.ijse.hello_shoes_test.reqsAndres.Secure.SignUp;
import lk.com.ijse.hello_shoes_test.reqsAndres.response.JwtAuthResponse;

public interface AuthenticationService {
    JwtAuthResponse signIn(SignIn signIn);
    JwtAuthResponse signUp(SignUp signUp);
}
