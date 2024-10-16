package com.example.stockmarkettracking.service.impl;

import com.example.stockmarkettracking.mapper.UserMapper;
import com.example.stockmarkettracking.model.Role;
import com.example.stockmarkettracking.model.User;
import com.example.stockmarkettracking.repository.UserRepository;
import com.example.stockmarkettracking.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDTO> getAllUsers() {
        logger.info("Fetching all users");
        return userRepository.findAll().stream()
                .map(userMapper::toUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserByPublicId(String publicId) {
        logger.info("Fetching user with publicId: {}", publicId);
        Optional<User> user = userRepository.findByPublicId(publicId);
        return user.map(userMapper::toUserDTO).orElse(null);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        logger.info("Creating new user with username: {}", userDTO.getUsername());
        User user = userMapper.toUser(userDTO);
        User savedUser = userRepository.save(user);
        return userMapper.toUserDTO(savedUser);
    }

    @Override
    public UserDTO updateUser(String publicId, UserDTO userDTO) {
        logger.info("Updating user with publicId: {}", publicId);
        Optional<User> existingUserOptional = userRepository.findByPublicId(publicId);
        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            existingUser.setUsername(userDTO.getUsername());
            Set<Role> roles = userDTO.getRoles().stream()
                    .map(Role::valueOf)
                    .collect(Collectors.toSet());
            existingUser.setRoles(roles);

            User updatedUser = userRepository.save(existingUser);

            return userMapper.toUserDTO(updatedUser);
        }
        return null;
    }

    @Override
    public void deleteUser(String publicId) {
        logger.info("Deleting user with publicId: {}", publicId);
        Optional<User> userOptional = userRepository.findByPublicId(publicId);
        userOptional.ifPresent(userRepository::delete);
    }
}
