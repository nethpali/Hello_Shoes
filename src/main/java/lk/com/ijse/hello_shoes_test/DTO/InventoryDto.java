package lk.com.ijse.hello_shoes_test.DTO;

import lk.com.ijse.hello_shoes_test.Entity.Inventory_Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InventoryDto {
    private String item_code;
    private String item_desc;
    private String item_picture;
    private String category;
    private int size;
    private Double unit_price_sales;
    private Double unit_price_buy;
    private Double expected_profit;
    private Double profit_margin;
    private String status;
    private Inventory_Gender gender;
    private String occasion;
    private String supplier_id;
    }
