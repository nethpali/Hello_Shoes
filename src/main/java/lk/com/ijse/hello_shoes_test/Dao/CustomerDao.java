package lk.com.ijse.hello_shoes_test.Dao;

import lk.com.ijse.hello_shoes_test.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer,String > {

}
