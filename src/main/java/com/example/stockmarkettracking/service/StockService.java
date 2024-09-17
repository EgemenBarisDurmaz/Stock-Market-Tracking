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
     * Retrieve a specific stock by its symbol.
     */
    public StockDTO getStockBySymbol(String symbol) {
        Stock stock = stockRepository.findBySymbol(symbol);
        if (stock == null) {
            throw new ResourceNotFoundException("Stock with symbol " + symbol + " not found.");
        }
        return convertToDTO(stock);
    }

    /**
     * Save a new stock to the database.
     */
    @Transactional
    public StockDTO saveStock(StockDTO stockDTO) {
        Stock stock = new Stock();
        stock.setSymbol(stockDTO.getSymbol());
        stock.setName(stockDTO.getName());
        stock.setPrice(stockDTO.getPrice());
        stock.setCurrency("EUR"); // Default currency
        Stock savedStock = stockRepository.save(stock);
        return convertToDTO(savedStock);
    }

    /**
     * Update an existing stock's details using its symbol.
     */
    @Transactional
    public StockDTO updateStock(String symbol, StockDTO stockDTO) {
        Stock stock = stockRepository.findBySymbol(symbol);
        if (stock == null) {
            throw new ResourceNotFoundException("Stock with symbol " + symbol + " not found.");
        }
        stock.setName(stockDTO.getName());
        stock.setPrice(stockDTO.getPrice());
        stock.setCurrency("EUR"); // Default currency
        Stock updatedStock = stockRepository.save(stock);
        return convertToDTO(updatedStock);
    }

    /**
     * Update the price of a stock using its symbol.
     */
    @Transactional
    public StockDTO updateStockPrice(String symbol, double newPrice) {
        Stock stock = stockRepository.findBySymbol(symbol);
        if (stock == null) {
            throw new ResourceNotFoundException("Stock with symbol " + symbol + " not found.");
        }
        stock.setPrice(newPrice);
        Stock updatedStock = stockRepository.save(stock);
        return convertToDTO(updatedStock);
    }

    /**
     * Delete a stock by its symbol.
     */
    @Transactional
    public void deleteStockBySymbol(String symbol) {
        Stock stock = stockRepository.findBySymbol(symbol);
        if (stock == null) {
            throw new ResourceNotFoundException("Stock with symbol " + symbol + " not found.");
        }
        stockRepository.delete(stock);
    }

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
