package com.example.stockmarkettracking.service.impl;

import com.example.stockmarkettracking.dto.StockDTO;
import com.example.stockmarkettracking.mapper.StockMapper;
import com.example.stockmarkettracking.model.Stock;
import com.example.stockmarkettracking.model.User;
import com.example.stockmarkettracking.repository.StockRepository;
import com.example.stockmarkettracking.service.StockService;
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
    public List<StockDTO> getAllStocks() {
        return stockRepository.findAll().stream()
                .map(stockMapper::toStockDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StockDTO getStockByPublicId(String publicId) {
        Optional<Stock> stock = stockRepository.findByPublicId(publicId);
        return stock.map(stockMapper::toStockDTO).orElse(null);
    }

    @Override
    public StockDTO createStock(StockDTO stockDTO) {
        Stock stock = stockMapper.toStock(stockDTO);
        Stock savedStock = stockRepository.save(stock);
        return stockMapper.toStockDTO(savedStock);
    }

    @Override
    public StockDTO updateStock(String publicId, StockDTO stockDTO) {
        Optional<Stock> existingStock = stockRepository.findByPublicId(publicId);
        if (existingStock.isPresent()) {
            Stock stock = existingStock.get();
            stock.setName(stockDTO.getName());
            stock.setSymbol(stockDTO.getSymbol());
            stock.setPrice(stockDTO.getPrice());
            Stock updatedStock = stockRepository.save(stock);
            return stockMapper.toStockDTO(updatedStock);
        }
        return null;
    }

    @Override
    public void deleteStock(String publicId) {
        Optional<Stock> stockOptional = stockRepository.findByPublicId(publicId);
        stockOptional.ifPresent(stockRepository::delete);
    }
}
