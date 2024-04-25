package lk.com.ijse.hello_shoes_test.Service.Impl;

import lk.com.ijse.hello_shoes_test.DTO.EmployeeDto;
import lk.com.ijse.hello_shoes_test.Dao.EmployeeDao;
import lk.com.ijse.hello_shoes_test.Dao.UserDao;
import lk.com.ijse.hello_shoes_test.Entity.Employee;
import lk.com.ijse.hello_shoes_test.Entity.User;
import lk.com.ijse.hello_shoes_test.Service.AuthenticationService;
import lk.com.ijse.hello_shoes_test.Service.EmployeeService;
import lk.com.ijse.hello_shoes_test.Util.Mapping;
import lk.com.ijse.hello_shoes_test.Util.UtilMatter;
import lk.com.ijse.hello_shoes_test.reqsAndres.Secure.SignUp;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeServiceIMPL implements EmployeeService {
    private final EmployeeDao employeeDao;
    private final Mapping mapping;
    private final AuthenticationService authenticationService;
    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;
    @Override
    public boolean saveEmployee(EmployeeDto employeeDto,String password) {
        Employee employee = mapping.toEmployeeEntity(employeeDto);
        EmployeeDto savedEmployee = mapping.toEmployeeDTO(employeeDao.save(employee));

        SignUp signUp = new SignUp();
        signUp.setEmail(employeeDto.getEmail());
        signUp.setPassword(password);
        signUp.setRole(String.valueOf(employeeDto.getRole()));

        authenticationService.signUp(signUp, employeeDto);

        return savedEmployee != null;
    }

    @Override
    public boolean deleteEmployee(String email) {
        Optional<Employee> employee = employeeDao.findByEmail(email);
        Optional<User> user = userDao.findByEmail(email);
        if (employee.isPresent() && user.isPresent()) {
            userDao.delete(user.get());
            employeeDao.delete(employee.get());
            return true;
        }else {
            return false;
        }
    }

    @Override
    public EmployeeDto getSelectedEmployee(String EmployeeCode) {
        return null;
    }

    @Override
    public boolean updateEmployee(String id, EmployeeDto employeeDto, String password) {
        Optional<Employee> employee = employeeDao.findById(id);
        String email = employee.get().getEmail();

        if (employee.isPresent()) {
            employee.get().setEmployee_name(employeeDto.getEmployee_name());
            employee.get().setEmployee_profile_pic(UtilMatter.convertBase64(employeeDto.getEmployee_profile_pic()));
            employee.get().setGender(employeeDto.getGender());
            employee.get().setStatus(employeeDto.getStatus());
            employee.get().setDesignation(employeeDto.getDesignation());
            employee.get().setRole(employeeDto.getRole());
            employee.get().setDob(employeeDto.getDob());
            employee.get().setDate(employeeDto.getDate());
            employee.get().setAttached_branch(employeeDto.getAttached_branch());
            employee.get().setAddressLine_01(employeeDto.getAddressLine_01());
            employee.get().setAddressLine_02(employeeDto.getAddressLine_02());
            employee.get().setAddressLine_03(employeeDto.getAddressLine_03());
            employee.get().setAddressLine_04(employeeDto.getAddressLine_04());
            employee.get().setAddressLine_05(employeeDto.getAddressLine_05());
            employee.get().setContactNo(employeeDto.getContactNo());
            employee.get().setEmail(employeeDto.getEmail());
            employee.get().setInform_in_case_of_emergency(employeeDto.getInform_in_case_of_emergency());
            employee.get().setEmergency_contactNo(employeeDto.getEmergency_contactNo());

            Optional<User> user = userDao.findByEmail(email);
            if (user.isPresent()) {
                user.get().setEmail(employeeDto.getEmail());
                user.get().setPassword(passwordEncoder.encode(password));
                user.get().setRole(employeeDto.getRole());
            }
            return true;
        }
        return false;
    }



    @Override
    public List<EmployeeDto> getAllEmployee() {
        return null;
    }
}
