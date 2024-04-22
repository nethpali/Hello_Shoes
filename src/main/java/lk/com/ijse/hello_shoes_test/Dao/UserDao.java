package lk.com.ijse.hello_shoes_test.Dao;

import lk.com.ijse.hello_shoes_test.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User,String> {
    Optional<User> findByEmail(String email);
}
