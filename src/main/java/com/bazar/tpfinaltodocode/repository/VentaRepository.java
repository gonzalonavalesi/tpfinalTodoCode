package com.bazar.tpfinaltodocode.repository;

import com.bazar.tpfinaltodocode.model.Producto;
import com.bazar.tpfinaltodocode.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface VentaRepository extends JpaRepository<Venta,Long> {
    boolean existsById(Long id);

}
