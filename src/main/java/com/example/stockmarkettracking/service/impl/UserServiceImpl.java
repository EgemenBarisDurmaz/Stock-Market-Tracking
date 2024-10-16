package com.example.stockmarkettracking.service.impl;

import com.example.stockmarkettracking.dto.input.UserCreationDTO;
import com.example.stockmarkettracking.dto.output.UserRetrievalDTO;
import com.example.stockmarkettracking.dto.input.UserUpdateDTO;
import com.example.stockmarkettracking.mapper.UserMapper;
import com.example.stockmarkettracking.model.User;
import com.example.stockmarkettracking.repository.UserRepository;
import com.example.stockmarkettracking.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserRetrievalDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::toUserRetrievalDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserRetrievalDTO getUserByUserName(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        return userMapper.toUserRetrievalDTO(user);
    }

    @Override
    public UserRetrievalDTO createUser(UserCreationDTO userCreationDTO) {
        logger.info("Creating new user with username: {}", userCreationDTO.getUsername());
        User user = userMapper.toUser(userCreationDTO);
        User savedUser = userRepository.save(user);
        return userMapper.toUserRetrievalDTO(savedUser);
    }

    @Override
    public UserRetrievalDTO updateUser(String username, UserUpdateDTO userUpdateDTO) {
        logger.info("Updating user with username: {}", username);
        User existingUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        existingUser.setPassword(userUpdateDTO.getPassword());
        User updatedUser = userRepository.save(existingUser);
        return userMapper.toUserRetrievalDTO(updatedUser);
    }

    @Override
    public void deleteUser(String username) {
        Optional<User> existingUser = userRepository.findByUsername(username);
        if (existingUser.isPresent()) {
            userRepository.delete(existingUser.get());
        } else {
            throw new EntityNotFoundException("User not found");
        }
    }
}
