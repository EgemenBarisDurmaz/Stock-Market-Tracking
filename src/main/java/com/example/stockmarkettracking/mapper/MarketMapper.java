package com.example.stockmarkettracking.mapper;

import com.example.stockmarkettracking.dto.input.MarketCreationDTO;
import com.example.stockmarkettracking.dto.input.MarketUpdateDTO;
import com.example.stockmarkettracking.dto.output.MarketRetrievalDTO;
import com.example.stockmarkettracking.model.Market;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MarketMapper {

    MarketRetrievalDTO toMarketRetrievalDTO(Market market);
    Market toMarket(MarketCreationDTO marketCreationDTO);

    @Mapping(target = "location", source = "location")
    void updateMarketFromDto(MarketUpdateDTO marketUpdateDTO, @MappingTarget Market market);
}
