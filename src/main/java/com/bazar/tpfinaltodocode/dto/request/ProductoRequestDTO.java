package com.bazar.tpfinaltodocode.dto.request;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoRequestDTO {
    private String nombre;
    private String marca;
    private BigDecimal costo;
    private Integer cantidad_disponible;

}
