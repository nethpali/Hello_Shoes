package lk.com.ijse.hello_shoes_test.DTO;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lk.com.ijse.hello_shoes_test.Entity.Gender;
import lk.com.ijse.hello_shoes_test.Entity.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDto {
    private String customer_code;
    private String customer_name;
    private Gender gender;
    private Date join_date;
    private Level level;
    private int total_point;
    private Date dob;
    private String address_01;
    private String address_02;
    private String address_03;
    private String address_04;
    private String address_05;
    private String contact_no;
    private String email;
    private Timestamp purchase_data;
}
