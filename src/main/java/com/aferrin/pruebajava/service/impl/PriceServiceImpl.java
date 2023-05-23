package com.aferrin.pruebajava.service.impl;

import com.aferrin.pruebajava.api.converter.PriceConverter;
import com.aferrin.pruebajava.api.dto.PriceResponseDTO;
import com.aferrin.pruebajava.domain.repository.PricesRepository;
import com.aferrin.pruebajava.service.PriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Slf4j
public class PriceServiceImpl implements PriceService {

  @Autowired
  PricesRepository repository;
  @Autowired
  PriceConverter converter;


  @Override
  public Optional<PriceResponseDTO> findPrice(LocalDateTime date, Integer productId, Long brandId) {

    Optional<PriceResponseDTO> first = repository
        .findByStartDateLessThanEqualAndEndDateGreaterThanAndProductIdAndBrand_IdOrderByPriorityDesc(
            date, date, productId, brandId).stream()
        .map(price ->
            converter.toDto(price))
        .findFirst();
    if(first.isPresent())
      System.out.println(first.get());
    return first;
  }

}
