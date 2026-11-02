package com.bazar.tpfinaltodocode.controller;

import com.bazar.tpfinaltodocode.dto.request.ProductoRequestDTO;
import com.bazar.tpfinaltodocode.dto.response.ProductoResponseDTO;
import com.bazar.tpfinaltodocode.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    @PostMapping()
    public ResponseEntity<ProductoResponseDTO>crear(@RequestBody ProductoRequestDTO productoRequestDTO){
        ProductoResponseDTO productoResponseDTO=productoService.crear(productoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoResponseDTO);
    }

    @DeleteMapping
    public ResponseEntity<String> baja(@PathVariable Long id){
        productoService.baja(id);
        return ResponseEntity.ok("Producto eliminado");
    }

    @PutMapping
    public ResponseEntity<ProductoResponseDTO>modificar(@PathVariable Long id, @RequestBody ProductoRequestDTO productoRequestDTO){
        ProductoResponseDTO productoResponseDTO= productoService.modificar(id, productoRequestDTO);
        return ResponseEntity.ok(productoResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<ProductoResponseDTO>> mostrarTodo() {
        return ResponseEntity.ok(productoService.mostrarTodo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> mostrarXid(@PathVariable Long id) {
        ProductoResponseDTO producto = productoService.buscarPorId(id);
        return ResponseEntity.ok(producto);
    }

    @GetMapping("/stock-mayor-a-5")
    public ResponseEntity<List<ProductoResponseDTO>>stockMayor5(){
        List<ProductoResponseDTO>productos=productoService.stockMayor5();
        return ResponseEntity.ok(productos);
    }
}
