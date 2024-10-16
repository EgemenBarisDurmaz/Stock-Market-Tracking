package com.example.stockmarkettracking.mapper;

import com.example.stockmarkettracking.dto.input.UserCreationDTO;
import com.example.stockmarkettracking.dto.output.UserRetrievalDTO;
import com.example.stockmarkettracking.dto.input.UserUpdateDTO;
import com.example.stockmarkettracking.model.Role;
import com.example.stockmarkettracking.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "roles", expression = "java(mapRolesToString(user.getRoles()))")
    UserRetrievalDTO toUserRetrievalDTO(User user);

    @Mapping(target = "roles", expression = "java(java.util.Set.of(com.example.stockmarkettracking.model.Role.USER))")  // Set default role to USER during creation
    User toUser(UserCreationDTO userCreationDTO);

    @Mapping(target = "roles", ignore = true)
    User toUser(UserUpdateDTO userUpdateDTO);

    default Set<String> mapRolesToString(Set<Role> roles) {
        return roles.stream().map(Enum::name).collect(Collectors.toSet());
    }
}
