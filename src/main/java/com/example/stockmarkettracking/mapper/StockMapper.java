package com.example.stockmarkettracking.mapper;

import com.example.stockmarkettracking.dto.input.StockCreationDTO;
import com.example.stockmarkettracking.dto.input.StockUpdateDTO;
import com.example.stockmarkettracking.dto.output.StockRetrievalDTO;
import com.example.stockmarkettracking.model.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StockMapper {

    StockRetrievalDTO toStockRetrievalDTO(Stock stock);

    Stock toStock(StockCreationDTO stockCreationDTO);

    void updateStockFromDto(StockUpdateDTO stockUpdateDTO, @MappingTarget Stock stock);
}
