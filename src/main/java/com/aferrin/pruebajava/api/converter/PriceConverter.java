package com.aferrin.pruebajava.api.converter;

import com.aferrin.pruebajava.api.dto.PriceResponseDTO;
import com.aferrin.pruebajava.domain.entity.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PriceConverter {


  @Mapping(source = "startDate", target = "startDate")
  @Mapping(source = "endDate", target = "endDate")
  @Mapping(source = "productId", target = "productId")
  @Mapping(source = "brand.id", target = "brandId")
  @Mapping(source = "priceList", target = "priceList")
  @Mapping(source = "amount", target = "price")
  @Mapping(source = "currency", target = "currency")
  PriceResponseDTO toDto(Price entity);


}