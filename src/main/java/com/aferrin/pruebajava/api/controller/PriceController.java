package com.aferrin.pruebajava.api.controller;

import com.aferrin.pruebajava.api.dto.PriceResponseDTO;
import com.aferrin.pruebajava.service.PriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("prices")
@Validated
public class PriceController {

  @Autowired
  PriceService service;

  @GetMapping(value = "", produces = "application/json")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<PriceResponseDTO> getPrice(

      @RequestParam
      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
      @NotNull
      LocalDateTime date,

      @NotNull
      @RequestParam
      Integer productId,

      @RequestParam
      @NotNull
      Long brandId) {

    return ResponseEntity.of(service.findPrice(date, productId, brandId));

  }

}
