package com.bazar.tpfinaltodocode.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
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
