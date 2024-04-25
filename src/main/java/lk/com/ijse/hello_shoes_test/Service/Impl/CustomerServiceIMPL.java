package lk.com.ijse.hello_shoes_test.Service.Impl;

import jakarta.transaction.Transactional;
import lk.com.ijse.hello_shoes_test.DTO.CustomerDto;
import lk.com.ijse.hello_shoes_test.Dao.CustomerDao;
import lk.com.ijse.hello_shoes_test.Service.CustomerService;
import lk.com.ijse.hello_shoes_test.Util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceIMPL implements CustomerService {
    private final CustomerDao customerDao;
    private final Mapping mapper;
    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        return mapper.toCustomerDto(customerDao.save(mapper.toCustomerEntity(customerDto)));

    }

    @Override
    public boolean updateCustomer(String id, CustomerDto customerDto) {
        return false;
    }

    @Override
    public boolean deleteCustomer(String id) {
        return false;
    }

    @Override
    public List<CustomerDto> getAllCustomer() {
        return null;
    }
}
