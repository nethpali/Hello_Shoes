package lk.com.ijse.hello_shoes_test.Service.Impl;

import lk.com.ijse.hello_shoes_test.DTO.UserDto;
import lk.com.ijse.hello_shoes_test.Dao.UserDao;
import lk.com.ijse.hello_shoes_test.Service.UserService;
import lk.com.ijse.hello_shoes_test.Util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceIMPL implements UserService {
    private final UserDao userDao;
    private final Mapping map;

    @Override
    public UserDetailsService userDetailsService() {
        return username ->
                userDao.findByEmail(username)
                        .orElseThrow(()->new UsernameNotFoundException("User Not Found"));
    }

    @Override
    public void save(UserDto user) {
        map.toUserDTO(userDao.save(map.toUserEntity(user)));
    }
}
