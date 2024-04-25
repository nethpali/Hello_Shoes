package lk.com.ijse.hello_shoes_test.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lk.com.ijse.hello_shoes_test.Entity.AcessRole;
import lk.com.ijse.hello_shoes_test.Entity.Gender;
import lk.com.ijse.hello_shoes_test.Entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDto {
    private String employee_code;
    private String employee_name;
    private String employee_profile_pic;
    private Gender gender;
    private String status;
    private String designation;
    private Role role;
    private Date date;
    private Date dob;
    private String attached_branch;
    private String addressLine_01;
    private String addressLine_02;
    private String addressLine_03;
    private String addressLine_04;
    private String addressLine_05;
    private String contactNo;
    private String email;
    private String inform_in_case_of_emergency;
    private String emergency_contactNo;
}
