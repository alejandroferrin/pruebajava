package com.aferrin.pruebajava.domain.repository;

import com.aferrin.pruebajava.domain.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PricesRepository extends JpaRepository<Price, Integer> {


  List<Price> findByStartDateLessThanEqualAndEndDateGreaterThanAndProductIdAndBrand_IdOrderByPriorityDesc(
      LocalDateTime startDateComparator, LocalDateTime endDateComparator, int productId, long brandId);


}
