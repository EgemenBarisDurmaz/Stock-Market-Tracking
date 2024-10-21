package com.example.stockmarkettracking.repository;

import com.example.stockmarkettracking.model.Market;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MarketRepository extends JpaRepository<Market, Long> {
    Optional<Market> findById(Long id);
}
