package lk.com.ijse.hello_shoes_test.Service.Impl;

import lk.com.ijse.hello_shoes_test.DTO.UserDto;
import lk.com.ijse.hello_shoes_test.Dao.UserDao;
import lk.com.ijse.hello_shoes_test.Entity.Role;
import lk.com.ijse.hello_shoes_test.Service.AuthenticationService;
import lk.com.ijse.hello_shoes_test.Service.JWTService;
import lk.com.ijse.hello_shoes_test.Util.Mapping;
import lk.com.ijse.hello_shoes_test.reqsAndres.Secure.SignIn;
import lk.com.ijse.hello_shoes_test.reqsAndres.Secure.SignUp;
import lk.com.ijse.hello_shoes_test.reqsAndres.response.JwtAuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceIMPL implements AuthenticationService {
    private final UserDao userDao;
    private final JWTService jwtService;
    private final Mapping map;

    //Utils
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    @Override
    public JwtAuthResponse signIn(SignIn signIn) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signIn.getEmail(),
                        signIn.getPassword()));
        var userByEmail=userDao.findByEmail(signIn.getEmail())
                .orElseThrow(()-> new UsernameNotFoundException("User not Found"));
        var generatedToken= jwtService.generateToken(userByEmail);
        return JwtAuthResponse.builder().token(generatedToken).build();
    }

    @Override
    public JwtAuthResponse signUp(SignUp signUp) {
        UserDto buildUser = UserDto.builder()
                .userId(UUID.randomUUID().toString())
                .email(signUp.getEmail())
                .password(passwordEncoder.encode(signUp.getPassword()))
                .role(Role.valueOf(signUp.getRole()))
                .build();
        var saveUser= userDao.save(map.toUserEntity(buildUser));
        String generateToken = jwtService.generateToken(saveUser);
        return JwtAuthResponse.builder().token(generateToken).build();
    }
}
