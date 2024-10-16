package com.example.stockmarkettracking.dto.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRetrievalDTO {
    private String username;
    private Set<String> roles;
    private Set<StockRetrievalDTO> stocks;
 }
