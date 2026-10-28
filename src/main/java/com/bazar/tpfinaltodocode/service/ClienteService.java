package com.bazar.tpfinaltodocode.service;

import com.bazar.tpfinaltodocode.dto.request.ClienteRequestDTO;
import com.bazar.tpfinaltodocode.dto.response.ClienteResponseDTO;
import com.bazar.tpfinaltodocode.dto.response.ProductoResponseDTO;
import com.bazar.tpfinaltodocode.mapper.ClienteMapper;
import com.bazar.tpfinaltodocode.model.Cliente;
import com.bazar.tpfinaltodocode.model.Producto;
import com.bazar.tpfinaltodocode.repository.ClienteRepository;
import com.bazar.tpfinaltodocode.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ProductoRepository productoRepository;
    private ClienteRepository clienteRepository;

    public ClienteResponseDTO alta(ClienteRequestDTO clienteRequestDTO){
        if(clienteRepository.existsByDni(clienteRequestDTO.getDni())){
            throw new RuntimeException("ya existe un cliente con ese dni registrado");
        }
        Cliente cliente=ClienteMapper.toEntity(clienteRequestDTO);
        return ClienteMapper.toDTO(clienteRepository.save(cliente));
    }

    public void baja (Long id){
        if(!(clienteRepository.existsById(id))){
            throw new RuntimeException("no existe cliente con ese id");
        }
        clienteRepository.deleteById(id);
    }

    public ClienteResponseDTO modificar(ClienteRequestDTO clienteRequestDTO, Long id){
        Cliente cliente=clienteRepository.findById(id).orElseThrow(()->new RuntimeException("cliente con esa id no existente"));
        cliente.setApellido(clienteRequestDTO.getApellido());
        cliente.setDni(clienteRequestDTO.getDni());
        cliente.setNombre(clienteRequestDTO.getNombre());
        cliente.setDni(clienteRequestDTO.getDni());
        return ClienteMapper.toDTO(clienteRepository.save(cliente));
    }

    public List<ClienteResponseDTO> mostrarTodo(){
        List<Cliente>lista=clienteRepository.findAll();
        return lista.stream().map(ClienteMapper::toDTO).toList();
    }

    public ClienteResponseDTO mostrarXid(Long id){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(()->new RuntimeException("cliente con id no encontrada"));
        return ClienteMapper.toDTO(cliente);
    }
}
