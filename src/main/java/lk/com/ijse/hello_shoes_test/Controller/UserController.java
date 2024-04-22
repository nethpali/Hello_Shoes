package lk.com.ijse.hello_shoes_test.Controller;

import lk.com.ijse.hello_shoes_test.Service.AuthenticationService;
import lk.com.ijse.hello_shoes_test.reqsAndres.Secure.SignIn;
import lk.com.ijse.hello_shoes_test.reqsAndres.Secure.SignUp;
import lk.com.ijse.hello_shoes_test.reqsAndres.response.JwtAuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private  final AuthenticationService authenticationService;

    @GetMapping("/health")
    public String healthTest(){
        return "User Health Test";
    }

    //sign up
    @PostMapping(value = "/signup")
    public ResponseEntity<JwtAuthResponse> signUp(@RequestBody SignUp signUp){
        return ResponseEntity.ok(authenticationService.signUp(signUp));
    }

    //signIn
    @PostMapping("/signin")
    public ResponseEntity<JwtAuthResponse> signIn(@RequestBody SignIn signIn){
        return ResponseEntity.ok(authenticationService.signIn(signIn));
    }
}
