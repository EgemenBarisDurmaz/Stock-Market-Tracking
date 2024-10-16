package com.example.stockmarkettracking.controller;

import com.example.stockmarkettracking.dto.input.StockCreationDTO;
import com.example.stockmarkettracking.dto.input.StockUpdateDTO;
import com.example.stockmarkettracking.dto.output.StockRetrievalDTO;
import com.example.stockmarkettracking.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping
    public ResponseEntity<List<StockRetrievalDTO>> getAllStocks() {
        List<StockRetrievalDTO> stocks = stockService.getAllStocks();
        if(stocks.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(stocks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockRetrievalDTO> getStockById(@PathVariable Long id) {
        StockRetrievalDTO stock = stockService.getStockById(id);
        return ResponseEntity.ok(stock);
    }

    @PostMapping
    public ResponseEntity<StockRetrievalDTO> createStock(@RequestBody StockCreationDTO stockCreationDTO) {
        StockRetrievalDTO stock = stockService.createStock(stockCreationDTO);
        return ResponseEntity.status(201).body(stock);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StockRetrievalDTO> updateStock(@PathVariable Long id, @RequestBody StockUpdateDTO stockUpdateDTO) {
        StockRetrievalDTO stock = stockService.updateStock(id, stockUpdateDTO);
        return ResponseEntity.ok(stock);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable Long id) {
        stockService.deleteStock(id);
        return ResponseEntity.noContent().build();  // 204 No Content
    }
}
