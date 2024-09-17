package com.example.stockmarkettracking.mapper;

import com.example.stockmarkettracking.dto.UserDTO;
import com.example.stockmarkettracking.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "roles", source = "roles")
    UserDTO toUserDTO(User user);

    User toUser(UserDTO userDTO);
}

