package com.bazar.tpfinaltodocode.model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fecha;
    @Column(precision = 10,scale = 2)
    private BigDecimal total;
    @ManyToMany
    List<Producto>listaProductos;
    @ManyToOne
    @JoinColumn(name = "codigo_cliente")
    private Cliente cliente;
}
