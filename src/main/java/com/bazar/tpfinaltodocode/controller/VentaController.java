package com.bazar.tpfinaltodocode.controller;

import com.bazar.tpfinaltodocode.dto.request.VentaRequestDTO;
import com.bazar.tpfinaltodocode.dto.response.MayorVentaDTO;
import com.bazar.tpfinaltodocode.dto.response.ProductoResponseDTO;
import com.bazar.tpfinaltodocode.dto.response.VentaReporteDTO;
import com.bazar.tpfinaltodocode.dto.response.VentaResponseDTO;
import com.bazar.tpfinaltodocode.service.VentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/ventas")
@RequiredArgsConstructor
public class VentaController {


    private final VentaService ventaService;

    @PostMapping("/crear")
    public ResponseEntity<VentaResponseDTO> alta(@RequestBody VentaRequestDTO ventaRequestDTO){
        VentaResponseDTO ventaResponseDTO= ventaService.alta(ventaRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(ventaResponseDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> baja(@PathVariable Long id){
        ventaService.eliminar(id);
        return ResponseEntity.ok("venta eliminado y stock devuelto");
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<VentaResponseDTO>modificar(@RequestBody VentaRequestDTO dto,@PathVariable Long id){
        VentaResponseDTO ventaResponseDTO= ventaService.modificar(dto,id);
        return ResponseEntity.ok(ventaResponseDTO);
    }

    @GetMapping()
    public ResponseEntity<List<VentaResponseDTO>>mostrarTodo(){
        return ResponseEntity.ok(ventaService.mostrarTodo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VentaResponseDTO>mostrarXid(@PathVariable Long id){
        return ResponseEntity.ok(ventaService.mostrarXid(id));
    }

    @GetMapping("/{id}/productos")
    public ResponseEntity<List<ProductoResponseDTO>>listaProductosXventa(@PathVariable Long id){
        List<ProductoResponseDTO> productoResponseDTO= ventaService.listaProductosXventa(id);
        return ResponseEntity.ok(productoResponseDTO);
    }

    @GetMapping("/reporte")
    public ResponseEntity<VentaReporteDTO> ventasXdia(@RequestParam LocalDate fecha){
        VentaReporteDTO ventaReporteDTO=ventaService.ventasXdia(fecha);
        return ResponseEntity.ok(ventaReporteDTO);
    }

    @GetMapping("/venta-mayor")
    public ResponseEntity<MayorVentaDTO>ventaMayor(){
        MayorVentaDTO mayorVentaDTO= ventaService.mayorVenta();
        return ResponseEntity.ok(mayorVentaDTO);
    }



}
