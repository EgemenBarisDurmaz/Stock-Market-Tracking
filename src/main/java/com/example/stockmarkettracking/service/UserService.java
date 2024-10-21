package com.example.stockmarkettracking.service;

import com.example.stockmarkettracking.dto.input.UserCreationDTO;
import com.example.stockmarkettracking.dto.input.UserUpdateDTO;
import com.example.stockmarkettracking.dto.output.UserRetrievalDTO;

import java.util.List;

public interface UserService {
    List<UserRetrievalDTO> getAllUsers();

    UserRetrievalDTO getUserByUsername(String username);

    UserRetrievalDTO createUser(UserCreationDTO userCreationDTO);

    UserRetrievalDTO updateUser(String username, UserUpdateDTO userUpdateDTO);

    void deleteUser(String username);
}
