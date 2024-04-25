package lk.com.ijse.hello_shoes_test.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="supplier")
public class Supplier {
    @Id
    private String supplier_code;
    private String supplier_name;
    @Enumerated(EnumType.STRING)
    private Category category;
    private String address_01;
    private String address_02;
    private String address_03;
    private String address_04;
    private String address_05;
    private String address_06;
    private String contact_no_01;
    private String contact_no_02;
    private String email;
}
