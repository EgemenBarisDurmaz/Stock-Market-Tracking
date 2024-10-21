package com.example.stockmarkettracking.dto.input;

import com.example.stockmarkettracking.model.Country;
import com.example.stockmarkettracking.model.MarketType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarketCreationDTO {
    private MarketType marketType;
    private Country country;
    private String location;
}
