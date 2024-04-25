package lk.com.ijse.hello_shoes_test.Controller;

import lk.com.ijse.hello_shoes_test.DTO.CustomerDto;
import lk.com.ijse.hello_shoes_test.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    @GetMapping("/health")
    public String healthTest(){
        return "Customer Health Test";
    }

    @PostMapping("/save")
    public CustomerDto saveCustomer(@RequestBody CustomerDto customerDto){
        customerDto.setCustomer_code(UUID.randomUUID().toString());
        return customerService.saveCustomer(customerDto);
    }
}
