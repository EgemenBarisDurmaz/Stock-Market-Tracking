package com.example.stockmarkettracking.controller;

import com.example.stockmarkettracking.dto.StockDTO;
import com.example.stockmarkettracking.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping
    public List<StockDTO> getAllStocks() {
        return stockService.getAllStocks();
    }

    @GetMapping("/{publicId}")
    public StockDTO getStockByPublicId(@PathVariable String publicId) {
        return stockService.getStockByPublicId(publicId);
    }

    @PostMapping
    public StockDTO createStock(@RequestBody StockDTO stockDTO) {
        return stockService.createStock(stockDTO);
    }

    @PutMapping("/{publicId}")
    public StockDTO updateStock(@PathVariable String publicId, @RequestBody StockDTO stockDTO) {
        return stockService.updateStock(publicId, stockDTO);
    }

    @DeleteMapping("/{publicId}")
    public void deleteStock(@PathVariable String publicId) {
        stockService.deleteStock(publicId);
    }
}
