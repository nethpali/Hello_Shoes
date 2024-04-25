package lk.com.ijse.hello_shoes_test.Dao;

import lk.com.ijse.hello_shoes_test.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeDao extends JpaRepository<Employee,String> {
    Optional<Employee> findByEmail(String email);
}
