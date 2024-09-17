package com.example.stockmarkettracking.service;

import com.example.stockmarkettracking.dto.StockDTO;
import com.example.stockmarkettracking.exception.ResourceNotFoundException;
import com.example.stockmarkettracking.model.Stock;
import com.example.stockmarkettracking.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    /**
     * Retrieve all stocks as a list of StockDTO.
     */
    public List<StockDTO> getAllStocks() {
        return stockRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }



    /**
     * Update the price of a stock using its symbol.
     */

    /**
     * Delete a stock by its symbol.
     */


    /**
     * Convert a Stock entity to a StockDTO.
     */
    private StockDTO convertToDTO(Stock stock) {
        StockDTO dto = new StockDTO();
        dto.setId(stock.getId());
        dto.setSymbol(stock.getSymbol());
        dto.setName(stock.getName());
        dto.setPrice(stock.getPrice());
        return dto;
    }
}
