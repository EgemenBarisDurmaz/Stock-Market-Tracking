package com.example.stockmarkettracking.service.impl;


import com.example.stockmarkettracking.dto.input.MarketCreationDTO;
import com.example.stockmarkettracking.dto.input.MarketUpdateDTO;
import com.example.stockmarkettracking.dto.output.MarketRetrievalDTO;
import com.example.stockmarkettracking.mapper.MarketMapper;
import com.example.stockmarkettracking.model.Market;
import com.example.stockmarkettracking.model.Stock;
import com.example.stockmarkettracking.repository.MarketRepository;
import com.example.stockmarkettracking.repository.StockRepository;
import com.example.stockmarkettracking.service.MarketService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MarketServiceImpl implements MarketService {

    @Autowired
    private MarketRepository marketRepository;

    @Autowired
    private MarketMapper marketMapper;
    @Autowired
    private StockRepository stockRepository;

    @Override
    public List<MarketRetrievalDTO> getAllMarkets() {
        return marketRepository.findAll().stream()
                .map(marketMapper::toMarketRetrievalDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MarketRetrievalDTO getMarketById(Long id) {
        Market market = marketRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Market not found"));
        return marketMapper.toMarketRetrievalDTO(market);
    }

    @Override
    public MarketRetrievalDTO createMarket(MarketCreationDTO marketCreationDTO) {
        Market market = marketMapper.toMarket(marketCreationDTO);
        marketRepository.save(market);
        return marketMapper.toMarketRetrievalDTO(market);
    }

    @Override
    public MarketRetrievalDTO updateMarket(Long id, MarketUpdateDTO marketUpdateDTO) {
        Market existingMarket = marketRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Stock not found"));

            marketMapper.updateMarketFromDto(marketUpdateDTO, existingMarket);
            Market updatedMarket = marketRepository.save(existingMarket);
            return marketMapper.toMarketRetrievalDTO(updatedMarket);
    }

    @Override
    public void deleteMarketById(Long id) {
        Optional<Market> existingMarket = marketRepository.findById(id);
        if(existingMarket.isPresent()) {
            marketRepository.delete(existingMarket.get());
        }
        else {
            throw new EntityNotFoundException("Market to be deleted not found");
        }
    }
}
