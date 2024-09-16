package com.example.stockmarkettracking.repository;

import com.example.stockmarkettracking.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Integer> {
    Stock findBySymbol(String symbol);
}