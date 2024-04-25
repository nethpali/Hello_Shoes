package lk.com.ijse.hello_shoes_test.Service.Impl;

import jakarta.transaction.Transactional;
import lk.com.ijse.hello_shoes_test.DTO.CustomerDto;
import lk.com.ijse.hello_shoes_test.Dao.CustomerDao;
import lk.com.ijse.hello_shoes_test.Entity.Customer;
import lk.com.ijse.hello_shoes_test.Service.CustomerService;
import lk.com.ijse.hello_shoes_test.Util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Customer> customer = customerDao.findById(id);
        if (customer.isPresent()) {
            customer.get().setCustomer_name(customerDto.getCustomer_name());
            customer.get().setGender(customerDto.getGender());
            customer.get().setJoin_date(customerDto.getJoin_date());
            customer.get().setLevel(customerDto.getLevel());
            customer.get().setTotal_point(customerDto.getTotal_point());
            customer.get().setDob(customerDto.getDob());
            customer.get().setAddress_01(customerDto.getAddress_01());
            customer.get().setAddress_02(customerDto.getAddress_02());
            customer.get().setAddress_03(customerDto.getAddress_03());
            customer.get().setAddress_04(customerDto.getAddress_04());
            customer.get().setAddress_05(customerDto.getAddress_05());
            customer.get().setContact_no(customerDto.getContact_no());
            customer.get().setEmail(customerDto.getEmail());
            customer.get().setPurchase_data(customerDto.getPurchase_data());

            return true;
        }
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
