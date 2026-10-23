package com.bazar.tpfinaltodocode.repository;

import com.bazar.tpfinaltodocode.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface VentaRepository extends JpaRepository<Venta,Long> {
}
