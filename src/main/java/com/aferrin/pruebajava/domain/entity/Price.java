package com.aferrin.pruebajava.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * The persistent class for the COUNTRIES database table.
 */
@Entity
@Table(
    name = "PRICES"
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Price {

//  @EmbeddedId
//  private PricePK id;

  @Id
  @Column(name = "PRICE_LIST", nullable = false)
  private Integer  priceList;

  @Column(name = "START_DATE")
  private LocalDateTime startDate;

  @Column(name = "END_DATE")
  private LocalDateTime endDate;

  @Column(name = "PRODUCT_ID")
  private int productId;

  @Column(name = "PRIORITY")
  private int priority;

  @ManyToOne
  @JoinColumn(name = "BRAND_ID", nullable = false)
  private Brand brand;

  @Column(name = "PRICE", nullable = false)
  private double amount;

  @Column(name = "CURRENCY", nullable = false)
  private String currency;

}
