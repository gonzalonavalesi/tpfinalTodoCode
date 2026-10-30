package com.bazar.tpfinaltodocode.service;

import com.bazar.tpfinaltodocode.dto.request.ProductoRequestDTO;
import com.bazar.tpfinaltodocode.dto.response.ProductoResponseDTO;
import com.bazar.tpfinaltodocode.mapper.ProductoMapper;
import com.bazar.tpfinaltodocode.model.Producto;
import com.bazar.tpfinaltodocode.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {
    private final ProductoRepository productoRepository;

    @Transactional
    public ProductoResponseDTO crear (ProductoRequestDTO dto){
        if(productoRepository.existsByNombre(dto.getNombre())){
            throw  new RuntimeException("ya existe producto con ese nombre");
        }
        if(dto.getCosto().compareTo(BigDecimal.ZERO)<=0){
            throw new RuntimeException("El costo debe ser mayor a 0");
        }

        Producto producto= ProductoMapper.toEntity(dto);

        return ProductoMapper.toDTO(productoRepository.save(producto));
    }

    @Transactional
    public void baja (Long id){
        if(!productoRepository.existsById(id)){
            throw new RuntimeException("producto no existente");
        }
        productoRepository.deleteById(id);
    }

    @Transactional
    public ProductoResponseDTO modificar (Long id, ProductoRequestDTO dto){
        Producto producto=productoRepository.findById(id).orElseThrow(()->new RuntimeException("producto con id no existente"));

        producto.setCantidad_disponible(dto.getCantidad_disponible());
        producto.setCosto(dto.getCosto());
        producto.setMarca(dto.getMarca());
        producto.setNombre(dto.getNombre());
        return ProductoMapper.toDTO(productoRepository.save(producto));
    }

    public List<ProductoResponseDTO> mostrarTodo (){
        List<Producto>lista=productoRepository.findAll();
        return lista.stream().map(ProductoMapper::toDTO).toList();
    }

    public ProductoResponseDTO buscarPorId(Long id) {

        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("El producto con ID " + id + " no existe."));

        return ProductoMapper.toDTO(producto);
    }

    public List<ProductoResponseDTO>stockMayor5 (){
        return productoRepository.findAll().stream().filter(p -> p.getCantidad_disponible()<5).map(ProductoMapper::toDTO).toList();
    }


}
