package com.example.stockmarkettracking.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockUpdateDTO {
    @NotBlank(message = "Name is required")
    private String name;

    @Positive(message = "Price has to be positive")
    private double price;

}
