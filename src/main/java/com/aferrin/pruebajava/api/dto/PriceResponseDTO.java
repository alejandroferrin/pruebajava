package com.aferrin.pruebajava.api.dto;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PriceResponseDTO {

  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private int productId;
  private int brandId;
  private int priceList;
  private double price;
  private String currency;


}
