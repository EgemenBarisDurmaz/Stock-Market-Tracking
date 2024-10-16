package com.example.stockmarkettracking.dto.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockRetrievalDTO {
    private Long id;
    private String symbol;
    private String name;
    private double price;
}
