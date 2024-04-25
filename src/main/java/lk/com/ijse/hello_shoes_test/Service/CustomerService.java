package lk.com.ijse.hello_shoes_test.Service;

import lk.com.ijse.hello_shoes_test.DTO.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto saveCustomer(CustomerDto customerDto);
    boolean updateCustomer(String id, CustomerDto customerDto);
    boolean deleteCustomer(String id);

    List<CustomerDto> getAllCustomer();
}
