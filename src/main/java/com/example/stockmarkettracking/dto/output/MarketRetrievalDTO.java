package com.example.stockmarkettracking.dto.output;


import com.example.stockmarkettracking.model.Country;
import com.example.stockmarkettracking.model.MarketType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarketRetrievalDTO {
    private Long id;
    private MarketType marketType;
    private Country country;
    private String location;
    private HashSet<StockRetrievalDTO> stocks;

}
