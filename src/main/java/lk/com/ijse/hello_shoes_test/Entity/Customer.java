package lk.com.ijse.hello_shoes_test.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="customer")
public class Customer implements SuperEntity{
    @Id
    private String customer_code;
    private String customer_name;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Date join_date;
    @Enumerated(EnumType.STRING)
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
