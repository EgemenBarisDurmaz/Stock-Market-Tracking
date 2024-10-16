package com.example.stockmarkettracking.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockCreationDTO {
    @NotBlank(message = "Symbol is required")
    @Pattern(regexp = "^[A-Z]{1,5}$", message = "Invalid stock symbol")
    private String symbol;

    @NotBlank(message = "Name is required")
    private String name;

    @Positive(message = "Price must be positive")
    private double price;

}
