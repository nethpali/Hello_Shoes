package lk.com.ijse.hello_shoes_test.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SizeId {
    private int size;
    private Inventory inventory;
}
