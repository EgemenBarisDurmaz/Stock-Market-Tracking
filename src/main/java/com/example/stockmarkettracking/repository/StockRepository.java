package com.example.stockmarkettracking.repository;

import com.example.stockmarkettracking.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {

    Optional<Stock> findById(Long id);
}
