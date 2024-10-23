package com.example.stockmarkettracking.controller;


import com.example.stockmarkettracking.dto.input.MarketCreationDTO;
import com.example.stockmarkettracking.dto.input.MarketUpdateDTO;
import com.example.stockmarkettracking.dto.output.MarketRetrievalDTO;
import com.example.stockmarkettracking.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/markets")
public class MarketController {

    @Autowired
    private MarketService marketService;

    @GetMapping
    public ResponseEntity<List<MarketRetrievalDTO>> getAllMarkets() {
        List<MarketRetrievalDTO> markets = marketService.getAllMarkets();
        if (!markets.isEmpty()) {

            return ResponseEntity.ok(markets);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarketRetrievalDTO> getMarketById(@PathVariable Long id) { //else senaryosu yaz
        MarketRetrievalDTO marketRetrievalDTO = marketService.getMarketById(id);
        return ResponseEntity.ok(marketRetrievalDTO);
    }

    @PostMapping
    public ResponseEntity<MarketRetrievalDTO> createMarket(@RequestBody MarketCreationDTO marketCreationDTO) {
        MarketRetrievalDTO createdMarket = marketService.createMarket(marketCreationDTO);
        return ResponseEntity.status(201).body(createdMarket);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarketRetrievalDTO> updateMarket(@PathVariable Long id, @RequestBody MarketUpdateDTO marketUpdateDTO) {
        MarketRetrievalDTO updatedMarket = marketService.updateMarket(id, marketUpdateDTO);
        return ResponseEntity.status(200).body(updatedMarket);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMarketById(@PathVariable Long id) {
        marketService.deleteMarketById(id);
        return ResponseEntity.noContent().build();
    }


}