package com.example.stockmarkettracking.mapper;

import com.example.stockmarkettracking.dto.StockDTO;
import com.example.stockmarkettracking.model.Stock;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StockMapper {

    StockDTO toStockDTO(Stock stock);
    Stock toStock(StockDTO stockDTO);

}
