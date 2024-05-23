package lk.com.ijse.hello_shoes_test.Dao;

import lk.com.ijse.hello_shoes_test.Entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryDao extends JpaRepository<Inventory,String> {
}
