package com.bazar.tpfinaltodocode.repository;

import com.bazar.tpfinaltodocode.dto.response.ProductoResponseDTO;
import com.bazar.tpfinaltodocode.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Long> {
    boolean existsByNombre(String nombre);

    boolean existsById(Long id);

}
