package com.example.stockmarkettracking.controller;

import com.example.stockmarkettracking.dto.StockDTO;
import com.example.stockmarkettracking.service.StockService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/stocks")
@Validated
public class StockController {

    @Autowired
    private StockService stockService;

    // Get all stocks
    @GetMapping
    public ResponseEntity<List<StockDTO>> getAllStocks() {
        List<StockDTO> stocks = stockService.getAllStocks();
        return ResponseEntity.ok(stocks);
    }

    // Get stock by symbol
    @GetMapping("/{symbol}")
    public ResponseEntity<StockDTO> getStockBySymbol(@PathVariable String symbol) {
        StockDTO stock = stockService.getStockBySymbol(symbol);
        return ResponseEntity.ok(stock);
    }

    // Add a new stock
    @PostMapping
    public ResponseEntity<StockDTO> saveStock(@Valid @RequestBody StockDTO stockDTO) {
        StockDTO savedStock = stockService.saveStock(stockDTO);
        URI location = URI.create(String.format("/api/stocks/%s", savedStock.getSymbol()));
        return ResponseEntity.created(location).body(savedStock);
    }

    // Update stock by symbol
    @PutMapping("/{symbol}")
    public ResponseEntity<StockDTO> updateStock(@PathVariable String symbol, @Valid @RequestBody StockDTO stockDTO) {
        StockDTO updatedStock = stockService.updateStock(symbol, stockDTO);
        return ResponseEntity.ok(updatedStock);
    }

    // Update stock price by symbol
    @PatchMapping("/{symbol}/price")
    public ResponseEntity<StockDTO> updateStockPrice(@PathVariable String symbol, @RequestParam double price) {
        StockDTO updatedStock = stockService.updateStockPrice(symbol, price);
        return ResponseEntity.ok(updatedStock);
    }

    // Delete stock by symbol
    @DeleteMapping("/{symbol}")
    public ResponseEntity<Void> deleteStock(@PathVariable String symbol) {
        stockService.deleteStockBySymbol(symbol);
        return ResponseEntity.noContent().build();
    }
}
