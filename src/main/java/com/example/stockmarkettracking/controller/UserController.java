package com.example.stockmarkettracking.controller;

import com.example.stockmarkettracking.dto.UserDTO;
import com.example.stockmarkettracking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{publicId}")
    public UserDTO getUserByPublicId(@PathVariable String publicId) {
        return userService.getUserByPublicId(publicId);
    }
    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @PutMapping("/{publicId}")
    public UserDTO updateUser(@PathVariable String publicId, @RequestBody UserDTO userDTO) {
        return userService.updateUser(publicId, userDTO);
    }

    @DeleteMapping("/{publicId}")
    public void deleteUser(@PathVariable String publicId) {
        userService.deleteUser(publicId);
    }
}
