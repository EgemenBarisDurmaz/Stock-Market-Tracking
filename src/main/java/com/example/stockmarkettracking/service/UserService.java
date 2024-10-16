package com.example.stockmarkettracking.service;

import com.example.stockmarkettracking.dto.UserCreationDTO;
import com.example.stockmarkettracking.dto.UserRetrievalDTO;
import com.example.stockmarkettracking.dto.UserUpdateDTO;

import java.util.List;

public interface UserService {
    List<UserRetrievalDTO> getAllUsers();
    UserRetrievalDTO getUserByUserName(String username);
    UserRetrievalDTO createUser(UserCreationDTO userCreationDTO);
    UserRetrievalDTO updateUser(String username, UserUpdateDTO userUpdateDTO);
    //tbu: put username in UserUpdateDTO if possible
    void deleteUser(String username);
}
