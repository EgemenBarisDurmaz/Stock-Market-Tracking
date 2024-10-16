package com.example.stockmarkettracking.service.impl;

import com.example.stockmarkettracking.dto.StockDTO;
import com.example.stockmarkettracking.dto.input.StockCreationDTO;
import com.example.stockmarkettracking.dto.input.StockUpdateDTO;
import com.example.stockmarkettracking.dto.output.StockRetrievalDTO;
import com.example.stockmarkettracking.mapper.StockMapper;
import com.example.stockmarkettracking.model.Stock;
import com.example.stockmarkettracking.model.User;
import com.example.stockmarkettracking.repository.StockRepository;
import com.example.stockmarkettracking.service.StockService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private StockMapper stockMapper;


    @Override
    public List<StockRetrievalDTO> getAllStocks() {
        return stockRepository.findAll().stream()
                .map(stockMapper::toStockRetrievalDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StockRetrievalDTO getStockById(Long id) {
        Stock stock = stockRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Stock not found"));
        return stockMapper.toStockRetrievalDTO(stock);
    }

    @Override
    public StockRetrievalDTO createStock(StockCreationDTO stockCreationDTO) {
        Stock stock = stockMapper.toStock(stockCreationDTO);
        Stock savedStock = stockRepository.save(stock);
        return stockMapper.toStockRetrievalDTO(savedStock);
    }

    @Override
    public StockRetrievalDTO updateStock(Long id, StockUpdateDTO stockUpdateDTO) {
        Stock existingStock = stockRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Stock not found"));

        stockMapper.updateStockFromDto(stockUpdateDTO, existingStock);
        Stock updatedStock = stockRepository.save(existingStock);
        return stockMapper.toStockRetrievalDTO(updatedStock);
    }

    @Override
    public void deleteStock(Long id) {
        Optional<Stock> existingStock = stockRepository.findById(id);
        if (existingStock.isPresent()) {
            stockRepository.delete(existingStock.get());
        } else {
            throw new EntityNotFoundException("Stock not found");
        }
    }


}
