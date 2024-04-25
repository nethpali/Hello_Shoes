package lk.com.ijse.hello_shoes_test.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="employee")
public class Employee implements SuperEntity{
    @Id
    private String employee_code;
    private String employee_name;
    @Column(columnDefinition = "LONGTEXT")
    private String employee_profile_pic;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String status;
    private String designation;
    @Enumerated(EnumType.STRING)
    private Role role;
    private Date dob;
    private Date date;
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
