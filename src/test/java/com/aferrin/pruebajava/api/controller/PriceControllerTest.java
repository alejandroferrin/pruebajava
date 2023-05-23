package com.aferrin.pruebajava.api.controller;

import com.aferrin.pruebajava.domain.repository.PricesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@SqlGroup({
    @Sql(value = "classpath:sql/inserts.sql", executionPhase = BEFORE_TEST_METHOD)
})
class PriceControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private PricesRepository repository;

  @Test
  void getPrice() throws Exception {


    mockMvc.perform(
            get("/prices")
                .param("date", "2020-06-14T10:00:00")
                .param("productId", "35455")
                .param("brandId", "1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.price").value(35.5));

    mockMvc.perform(
            get("/prices")
                .param("date", "2020-06-14T16:00:00")
                .param("productId", "35455")
                .param("brandId", "1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.price").value(25.45));

    mockMvc.perform(
            get("/prices")
                .param("date", "2020-06-14T09:00:00")
                .param("productId", "35455")
                .param("brandId", "1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.price").value(35.5));

    mockMvc.perform(
            get("/prices")
                .param("date", "2020-06-15T10:00:00")
                .param("productId", "35455")
                .param("brandId", "1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.price").value(30.5));

    mockMvc.perform(
            get("/prices")
                .param("date", "2020-06-16T21:00:00")
                .param("productId", "35455")
                .param("brandId", "1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.price").value(38.95));

    mockMvc.perform(
            get("/prices")
                .param("date", "2002-06-16T21:00:00")
                .param("productId", "35455")
                .param("brandId", "1"))
        .andExpect(status().isNotFound());

  }

}