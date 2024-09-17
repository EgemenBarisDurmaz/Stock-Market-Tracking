package com.example.stockmarkettracking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockDTO {
    private String publicId;
    private String symbol;
    private String name;
    private double price;
}
