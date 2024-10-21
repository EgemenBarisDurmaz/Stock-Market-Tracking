package com.example.stockmarkettracking.controller;

import com.example.stockmarkettracking.dto.input.UserCreationDTO;
import com.example.stockmarkettracking.dto.input.UserUpdateDTO;
import com.example.stockmarkettracking.dto.output.UserRetrievalDTO;
import com.example.stockmarkettracking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping
    public ResponseEntity<List<UserRetrievalDTO>> getAllUsers() {
        List<UserRetrievalDTO> users = userService.getAllUsers();
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();  // Return 204 No Content if no users found
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserRetrievalDTO> getUserByUsername(@PathVariable String username) {
        UserRetrievalDTO user = userService.getUserByUsername(username);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<UserRetrievalDTO> createUser(@RequestBody UserCreationDTO userCreationDTO) {
        UserRetrievalDTO createdUser = userService.createUser(userCreationDTO);
        return ResponseEntity.status(201).body(createdUser);
    }

    @PutMapping("/{username}")
    public ResponseEntity<UserRetrievalDTO> updateUser(@PathVariable String username, @RequestBody UserUpdateDTO userUpdateDTO) {
        UserRetrievalDTO updatedUser = userService.updateUser(username, userUpdateDTO);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable String username) {
        userService.deleteUser(username);
        return ResponseEntity.noContent().build();
    }
}
