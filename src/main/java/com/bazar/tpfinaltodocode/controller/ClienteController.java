package com.bazar.tpfinaltodocode.controller;

import com.bazar.tpfinaltodocode.dto.request.ClienteRequestDTO;
import com.bazar.tpfinaltodocode.dto.response.ClienteResponseDTO;
import com.bazar.tpfinaltodocode.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;


    @PostMapping("/crear")
    public ResponseEntity<ClienteResponseDTO> alta(@RequestBody ClienteRequestDTO clienteRequestDTO) {
        ClienteResponseDTO clienteCreado = clienteService.alta(clienteRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteCreado);
    }


    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> mostrarTodo() {
        return ResponseEntity.ok(clienteService.mostrarTodo());
    }


    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> mostrarXid(@PathVariable Long id) {
        ClienteResponseDTO cliente = clienteService.mostrarXid(id);
        return ResponseEntity.ok(cliente);
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> baja(@PathVariable Long id) {
        clienteService.baja(id);
        return ResponseEntity.ok("Cliente eliminado correctamente");
    }


    @PutMapping("/modificar/{id}")
    public ResponseEntity<ClienteResponseDTO> modificar(@RequestBody ClienteRequestDTO dto, @PathVariable Long id) {
        ClienteResponseDTO clienteModificado = clienteService.modificar(dto, id);
        return ResponseEntity.ok(clienteModificado);
    }
}