package com.example.stockmarkettracking.service;

import com.example.stockmarkettracking.dto.input.UserCreationDTO;
import com.example.stockmarkettracking.dto.output.UserRetrievalDTO;
import com.example.stockmarkettracking.dto.input.UserUpdateDTO;

import java.util.List;

public interface UserService {
    List<UserRetrievalDTO> getAllUsers();
    UserRetrievalDTO getUserByUserName(String username);
    UserRetrievalDTO createUser(UserCreationDTO userCreationDTO);
    UserRetrievalDTO updateUser(String username, UserUpdateDTO userUpdateDTO);
    void deleteUser(String username);
}
