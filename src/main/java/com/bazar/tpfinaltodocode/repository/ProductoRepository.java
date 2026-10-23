package com.bazar.tpfinaltodocode.repository;

import com.bazar.tpfinaltodocode.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Long> {
}
