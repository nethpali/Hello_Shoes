package lk.com.ijse.hello_shoes_test.Controller;

import lk.com.ijse.hello_shoes_test.DTO.EmployeeDto;
import lk.com.ijse.hello_shoes_test.Entity.Gender;
import lk.com.ijse.hello_shoes_test.Entity.Role;
import lk.com.ijse.hello_shoes_test.Service.EmployeeService;
import lk.com.ijse.hello_shoes_test.Util.UtilMatter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/health")
    public String healthTest(){
        return "Employee Health Test";
    }

    @PostMapping(value = "/save")
    public boolean save(
        @RequestPart("employee_name") String employeeName,
        @RequestPart("employee_profile_pic") String employeeProfilePic,
        @RequestPart("gender") String gender,
        @RequestPart("status") String status,
        @RequestPart("designation") String designation,
        @RequestPart("role") String role,
        @RequestPart("dob") String dob,
        @RequestPart("date") String joinDate,
        @RequestPart("attached_branch") String attachedBranch,
        @RequestPart("addressLine_01") String employeeAddress1,
        @RequestPart("addressLine_02") String employeeAddress2,
        @RequestPart("addressLine_03") String employeeAddress3,
        @RequestPart("addressLine_04") String employeeAddress4,
        @RequestPart("addressLine_05") String employeeAddress5,
        @RequestPart("contactNo") String contactNo,
        @RequestPart("email") String email,
        @RequestPart("inform_in_case_of_emergency") String informInCaseOfEmergency,
        @RequestPart("emergency_contactNo") String emergencyContactNo,
        @RequestPart("password") String password) throws ParseException {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setEmployee_code(UUID.randomUUID().toString());
            employeeDto.setEmployee_name(employeeName);
            employeeDto.setEmployee_profile_pic(UtilMatter.convertBase64(employeeProfilePic));
            employeeDto.setGender(Gender.valueOf(gender));
            employeeDto.setStatus(status);
            employeeDto.setDesignation(designation);
            employeeDto.setRole(Role.valueOf(String.valueOf(Role.valueOf(role))));
            employeeDto.setDob(dateFormat.parse(dob));
            employeeDto.setDate(dateFormat.parse(joinDate));
            employeeDto.setAttached_branch(attachedBranch);
            employeeDto.setAddressLine_01(employeeAddress1);
            employeeDto.setAddressLine_02(employeeAddress2);
            employeeDto.setAddressLine_03(employeeAddress3);
            employeeDto.setAddressLine_04(employeeAddress4);
            employeeDto.setAddressLine_05(employeeAddress5);
            employeeDto.setContactNo(contactNo);
            employeeDto.setEmail(email);
            employeeDto.setInform_in_case_of_emergency(informInCaseOfEmergency);
            employeeDto.setEmergency_contactNo(emergencyContactNo);

            System.out.println(employeeDto.getEmployee_name());
            System.out.println(employeeDto.getAddressLine_01());
            System.out.println(employeeDto.getAddressLine_02());

            return employeeService.saveEmployee(employeeDto, password);
    }
    @PutMapping(value = "/update")
    @PreAuthorize("hasRole(('ADMIN'))")
    public boolean updateEmployee(
            @RequestPart("employee_code") String employeeId,
            @RequestPart("employee_name") String employeeName,
            @RequestPart("employee_profile_pic") String employeeProfilePic,
            @RequestPart("gender") String gender,
            @RequestPart("status") String status,
            @RequestPart("designation") String designation,
            @RequestPart("role") String role,
            @RequestPart("dob") String dob,
            @RequestPart("date") String joinDate,
            @RequestPart("attached_branch") String attachedBranch,
            @RequestPart("addressLine_01") String employeeAddress1,
            @RequestPart("addressLine_02") String employeeAddress2,
            @RequestPart("addressLine_03") String employeeAddress3,
            @RequestPart("addressLine_04") String employeeAddress4,
            @RequestPart("addressLine_05") String employeeAddress5,
            @RequestPart("contactNo") String contactNo,
            @RequestPart("email") String email,
            @RequestPart("inform_in_case_of_emergency") String informInCaseOfEmergency,
            @RequestPart("emergency_contactNo") String emergencyContactNo,
            @RequestPart("password") String password) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployee_code(UUID.randomUUID().toString());
        employeeDto.setEmployee_name(employeeName);
        employeeDto.setEmployee_profile_pic(UtilMatter.convertBase64(employeeProfilePic));
        employeeDto.setGender(Gender.valueOf(gender));
        employeeDto.setStatus(status);
        employeeDto.setDesignation(designation);
        employeeDto.setRole(Role.valueOf(role));
        employeeDto.setDob(dateFormat.parse(dob));
        employeeDto.setDate(dateFormat.parse(joinDate));
        employeeDto.setAttached_branch(attachedBranch);
        employeeDto.setAddressLine_01(employeeAddress1);
        employeeDto.setAddressLine_02(employeeAddress2);
        employeeDto.setAddressLine_03(employeeAddress3);
        employeeDto.setAddressLine_04(employeeAddress4);
        employeeDto.setAddressLine_05(employeeAddress5);
        employeeDto.setContactNo(contactNo);
        employeeDto.setEmail(email);
        employeeDto.setInform_in_case_of_emergency(informInCaseOfEmergency);
        employeeDto.setEmergency_contactNo(emergencyContactNo);

        return employeeService.updateEmployee(employeeId, employeeDto, password);
    }
    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public boolean deleteEmployee(String email){
        return employeeService.deleteEmployee(email);
    }
}
