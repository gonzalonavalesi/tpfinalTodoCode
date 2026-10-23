package com.bazar.tpfinaltodocode.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductoRequestDTO {
    private String nombre;
    private String marca;
    private BigDecimal costo;
    private Integer cantidad_disponible;

}
