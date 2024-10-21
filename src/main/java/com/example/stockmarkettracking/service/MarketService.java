package com.example.stockmarkettracking.service;

import com.example.stockmarkettracking.dto.input.MarketCreationDTO;
import com.example.stockmarkettracking.dto.input.MarketUpdateDTO;
import com.example.stockmarkettracking.dto.output.MarketRetrievalDTO;
import com.example.stockmarkettracking.model.Market;

import java.util.List;

public interface MarketService {
    List<MarketRetrievalDTO> getAllMarkets();
    MarketRetrievalDTO getMarketById(Long id);
    MarketRetrievalDTO createMarket(MarketCreationDTO marketCreationDTO);
    MarketRetrievalDTO updateMarket(Long id, MarketUpdateDTO marketUpdateDTO);
    void deleteMarketById(Long id);
}
