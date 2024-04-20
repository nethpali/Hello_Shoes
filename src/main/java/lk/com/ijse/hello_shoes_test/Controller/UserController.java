package lk.com.ijse.hello_shoes_test.Controller;

import lk.com.ijse.hello_shoes_test.Service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    @GetMapping("/health")
    public String healthTest(){
        return "User Health Test";
    }
}
