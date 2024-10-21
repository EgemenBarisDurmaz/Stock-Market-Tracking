package com.example.stockmarkettracking.service;

import com.example.stockmarkettracking.dto.input.StockCreationDTO;
import com.example.stockmarkettracking.dto.input.StockUpdateDTO;
import com.example.stockmarkettracking.dto.output.StockRetrievalDTO;

import java.util.List;

public interface StockService {
    List<StockRetrievalDTO> getAllStocks();

    StockRetrievalDTO getStockById(Long id);

    StockRetrievalDTO createStock(StockCreationDTO stockCreationDTO);

    StockRetrievalDTO updateStock(Long id, StockUpdateDTO stockUpdateDTO);

    void deleteStock(Long id);
}
