package com.example.stockmarkettracking.dto;

import com.example.stockmarkettracking.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String publicId;
    private String username;
    private Set<String> roles;
}
