package com.example.stockmarkettracking.service;

import com.example.stockmarkettracking.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO getUserByPublicId(String publicId);
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(String publicId, UserDTO userDTO);
    void deleteUser(String publicId);
}
