package lk.com.ijse.hello_shoes_test.Util;

import lk.com.ijse.hello_shoes_test.DTO.CustomerDto;
import lk.com.ijse.hello_shoes_test.DTO.EmployeeDto;
import lk.com.ijse.hello_shoes_test.DTO.SupplierDto;
import lk.com.ijse.hello_shoes_test.DTO.UserDto;
import lk.com.ijse.hello_shoes_test.Entity.Customer;
import lk.com.ijse.hello_shoes_test.Entity.Employee;
import lk.com.ijse.hello_shoes_test.Entity.Supplier;
import lk.com.ijse.hello_shoes_test.Entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    private final ModelMapper modelMapper;

    public Mapping(ModelMapper modelMapper) {
        this.modelMapper =modelMapper;
    }

    //UserMapping
    public UserDto toUserDTO(User user){
        return modelMapper.map(user, UserDto.class);
    }
    public User toUserEntity(UserDto userDTO){
        return modelMapper.map(userDTO,User.class);
    }

    public List<User> toUserDTOList(List<User> users){
        return modelMapper.map(users,List.class);
    }


//    ------------Employee-------------------------//

    public EmployeeDto toEmployeeDTO(Employee employee){
        return modelMapper.map(employee,EmployeeDto.class);
    }

    public Employee toEmployeeEntity(EmployeeDto employeeDto){
        return modelMapper.map(employeeDto,Employee.class);
    }

    public List<EmployeeDto> toEmployeeList(List<Employee> employees){
        return modelMapper.map(employees,List.class);
    }


    //-------------------Customer-------------------------//

    public CustomerDto toCustomerDto(Customer customer){
        return modelMapper.map(customer,CustomerDto.class);
    }

    public Customer toCustomerEntity(CustomerDto customerDto){
        return modelMapper.map(customerDto,Customer.class);
    }

    public List<CustomerDto> toCustomerList(List<Customer> customers){
        return modelMapper.map(customers,List.class);
    }


    //-----------------------Supplier----------//

    public SupplierDto toSupplierDto(Supplier supplier){
        return modelMapper.map(supplier,SupplierDto.class);
    }

    public Supplier toSupplierEntity(SupplierDto supplierDto){
        return modelMapper.map(supplierDto,Supplier.class);
    }

    public List<SupplierDto> toSupplierList(List<Supplier> suppliers){
        return modelMapper.map(suppliers,List.class);
    }


}
