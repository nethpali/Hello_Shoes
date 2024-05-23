package lk.com.ijse.hello_shoes_test.Service.Impl;

import jakarta.transaction.Transactional;
import lk.com.ijse.hello_shoes_test.DTO.InventoryDto;
import lk.com.ijse.hello_shoes_test.DTO.SupplierDto;
import lk.com.ijse.hello_shoes_test.Dao.CustomerDao;
import lk.com.ijse.hello_shoes_test.Dao.InventoryDao;
import lk.com.ijse.hello_shoes_test.Service.InventoryService;
import lk.com.ijse.hello_shoes_test.Util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class InventoryServiceIMPL implements InventoryService {

    @Override
    public InventoryDto saveInventory(InventoryDto inventoryDto, String supplier_id) {
        return null;
    }

    @Override
    public boolean updateInventory(String id, InventoryDto inventoryDto) {
        return false;
    }

    @Override
    public boolean deleteInventory(String id) {
        return false;
    }

    @Override
    public String generateNextId(String occupation, String gender) {
        return null;
    }

    @Override
    public InventoryDto selectInventoryById(String id) throws ChangeSetPersister.NotFoundException {
        return null;
    }

    @Override
    public boolean updateImg(String itemCode, String pic) {
        return false;
    }

    @Override
    public List<String> getSize(String itemCode) {
        return null;
    }

    @Override
    public List<InventoryDto> getAllInventory() {
        return null;
    }
}
