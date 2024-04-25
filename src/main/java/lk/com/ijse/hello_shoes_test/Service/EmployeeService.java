package lk.com.ijse.hello_shoes_test.Service;

import lk.com.ijse.hello_shoes_test.DTO.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    boolean saveEmployee(EmployeeDto employeeDto,String password);
    boolean deleteEmployee(String email);
    EmployeeDto getSelectedEmployee(String EmployeeCode);
    boolean updateEmployee(String id, EmployeeDto employeeDto, String password);

    List<EmployeeDto>getAllEmployee();

}
