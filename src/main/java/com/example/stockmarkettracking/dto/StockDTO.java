package com.example.stockmarkettracking.dto;

import lombok.Data;

@Data
public class StockDTO {
    private Long id;
    private String symbol;
    private String name;
    private double price;
}
