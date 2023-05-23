package com.aferrin.pruebajava.domain.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
    name = "BRANDS"
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Brand {

  @Id
  @Column(name = "ID")
  private long id;

  @Column(name = "NAME", nullable = false)
  private String name;

}
