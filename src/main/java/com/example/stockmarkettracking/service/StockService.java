package com.example.stockmarkettracking.service;

import com.example.stockmarkettracking.dto.StockDTO;

import java.util.List;

public interface StockService {
    List<StockDTO> getAllStocks();
    StockDTO getStockByPublicId(String publicId);
    StockDTO createStock(StockDTO stockDTO);
    StockDTO updateStock(String publicId, StockDTO stockDTO);
    void deleteStock(String publicId);
}
