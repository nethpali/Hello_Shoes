package lk.com.ijse.hello_shoes_test.Service;

import lk.com.ijse.hello_shoes_test.DTO.InventoryDto;
import lk.com.ijse.hello_shoes_test.DTO.SupplierDto;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface    InventoryService {
    InventoryDto saveInventory(InventoryDto inventoryDto,String supplier_id);
    boolean updateInventory(String id,  InventoryDto inventoryDto);
    boolean deleteInventory(String id);
    String generateNextId(String occupation, String gender);
    InventoryDto selectInventoryById(String id) throws ChangeSetPersister.NotFoundException;
    boolean updateImg(String itemCode, String pic);
    List<String> getSize(String itemCode);

    List<InventoryDto> getAllInventory();
}
