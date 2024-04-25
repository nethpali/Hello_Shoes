package lk.com.ijse.hello_shoes_test.Dao;

import lk.com.ijse.hello_shoes_test.Entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierDao extends JpaRepository<Supplier,String > {
}
