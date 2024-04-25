package lk.com.ijse.hello_shoes_test.DTO;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lk.com.ijse.hello_shoes_test.Entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SupplierDto {
    private String supplier_code;
    private String supplier_name;
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
