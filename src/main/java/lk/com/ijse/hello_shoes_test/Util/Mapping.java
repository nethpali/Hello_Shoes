package lk.com.ijse.hello_shoes_test.Util;

import lk.com.ijse.hello_shoes_test.DTO.UserDto;
import lk.com.ijse.hello_shoes_test.Entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    private final ModelMapper modelMapper;

    public Mapping(ModelMapper modelMapper) {
        this.modelMapper =modelMapper;
    }

    //UserMapping
    public UserDto toUserDTO(User user){
        return modelMapper.map(user, UserDto.class);
    }
    public User toUserEntity(UserDto userDTO){
        return modelMapper.map(userDTO,User.class);
    }

    public List<User> toUserDTOList(List<User> users){
        return modelMapper.map(users,List.class);
    }
}
