package com.aferrin.pruebajava.service;

import com.aferrin.pruebajava.api.dto.PriceResponseDTO;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceService {
  public Optional<PriceResponseDTO> findPrice(LocalDateTime date, Integer productId, Long brandId);
}
