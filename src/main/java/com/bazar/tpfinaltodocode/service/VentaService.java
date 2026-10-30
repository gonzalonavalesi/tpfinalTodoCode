package com.bazar.tpfinaltodocode.service;

import com.bazar.tpfinaltodocode.dto.request.VentaRequestDTO;
import com.bazar.tpfinaltodocode.dto.response.MayorVentaDTO;
import com.bazar.tpfinaltodocode.dto.response.ProductoResponseDTO;
import com.bazar.tpfinaltodocode.dto.response.VentaReporteDTO;
import com.bazar.tpfinaltodocode.dto.response.VentaResponseDTO;
import com.bazar.tpfinaltodocode.mapper.ProductoMapper;
import com.bazar.tpfinaltodocode.mapper.VentaMapper;
import com.bazar.tpfinaltodocode.model.Cliente;
import com.bazar.tpfinaltodocode.model.Producto;
import com.bazar.tpfinaltodocode.model.Venta;
import com.bazar.tpfinaltodocode.repository.ClienteRepository;
import com.bazar.tpfinaltodocode.repository.ProductoRepository;
import com.bazar.tpfinaltodocode.repository.VentaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VentaService {

    private final VentaRepository ventaRepository;
    private final ClienteRepository clienteRepository;
    private final ProductoRepository productoRepository;
    private final ProductoService productoService;

    @Transactional
    public VentaResponseDTO alta (VentaRequestDTO dto){
        Cliente cliente= clienteRepository.findById(dto.getCodigo_cliente()).orElseThrow(()->new RuntimeException("cliente con id no existente"));

        BigDecimal total= BigDecimal.ZERO;
        List<Producto> list= new ArrayList<>();

        for(Long productoId : dto.getListaProductos()){
            Producto producto = productoRepository.findById(productoId).orElseThrow(()->new RuntimeException("producto no existetente"));

            if(producto.getCantidad_disponible()<1){
                throw new RuntimeException("no hay stock");
            }

            producto.setCantidad_disponible(producto.getCantidad_disponible()-1);
            list.add(producto);
            total= total.add(producto.getCosto());
        }

        Venta venta= new Venta();
        venta.setCliente(cliente);
        venta.setFecha(LocalDateTime.now());
        venta.setTotal(total);
        venta.setListaProductos(list);

        return VentaMapper.toDTO(ventaRepository.save(venta));
    }

    @Transactional
    public void baja (Long id){
        if(!(ventaRepository.existsById(id))){
            throw new RuntimeException("venta no existe");
        }
        ventaRepository.deleteById(id);
    }

    public VentaResponseDTO modificar(VentaRequestDTO dto, Long id){
        Venta venta=ventaRepository.findById(id).orElseThrow(()->new RuntimeException("venta no existe"));

        Cliente cliente = clienteRepository.findById(dto.getCodigo_cliente())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ese ID"));

        for(Producto productoViejo : venta.getListaProductos()){
            productoViejo.setCantidad_disponible(productoViejo.getCantidad_disponible()+1);
            productoRepository.save(productoViejo);
        }

        List<Producto> nuevaListaProductos = new ArrayList<>();
        BigDecimal nuevoTotal = BigDecimal.ZERO;

        for (Long productoId : dto.getListaProductos()) {
            Producto productoNuevo = productoRepository.findById(productoId)
                    .orElseThrow(() -> new RuntimeException("Producto con ID " + productoId + " no existente"));

            if (productoNuevo.getCantidad_disponible() < 1) {
                throw new RuntimeException("No hay stock suficiente para el producto: " + productoNuevo.getNombre());
            }

            productoNuevo.setCantidad_disponible(productoNuevo.getCantidad_disponible() - 1);
            productoRepository.save(productoNuevo);

            nuevaListaProductos.add(productoNuevo);
            nuevoTotal = nuevoTotal.add(productoNuevo.getCosto());
    }

        venta.setCliente(cliente);
        venta.setListaProductos(nuevaListaProductos);
        venta.setTotal(nuevoTotal);

        return VentaMapper.toDTO(ventaRepository.save(venta));
}

    public List<VentaResponseDTO> mostrarTodo(){
        List<Venta> venta=ventaRepository.findAll();
        return venta.stream().map(VentaMapper::toDTO).toList();
    }

    public VentaResponseDTO mostrarXid(Long id){
        Venta venta= ventaRepository.findById(id).orElseThrow(()->new RuntimeException("venta con esa id no existente"));
        return VentaMapper.toDTO(venta);
    }

    public void eliminar(Long id){
        Venta venta=ventaRepository.findById(id).orElseThrow(()->new RuntimeException("venta con esa id no existente"));
        List<Producto>productoList=venta.getListaProductos();

        for(Producto producto : venta.getListaProductos()){
            producto.setCantidad_disponible(producto.getCantidad_disponible()+1);
            productoRepository.save(producto);
        }
        ventaRepository.deleteById(id);
    }

    public List<ProductoResponseDTO>listaProductosXventa(Long id){
        Venta venta=ventaRepository.findById(id).orElseThrow(()->new RuntimeException("venta inexistente"));


        List<ProductoResponseDTO>list=new ArrayList<>();
        for(Producto producto : venta.getListaProductos()){
            list.add(ProductoMapper.toDTO(producto));
        }
        return list;
    }

    public VentaReporteDTO ventasXdia (LocalDate fecha){
        List<Venta>ventaList=ventaRepository.findAll().stream().filter(v->v.getFecha().toLocalDate().isEqual(fecha)).toList();
        int cantidad=ventaList.size();
        BigDecimal sumatoria = BigDecimal.ZERO;
        for(Venta venta : ventaList){
            sumatoria=sumatoria.add(venta.getTotal());
        }
        return new VentaReporteDTO(cantidad,sumatoria);
    }

    public MayorVentaDTO mayorVenta(){
        Venta venta=ventaRepository.findAll().stream().max(Comparator.comparing(Venta::getTotal)).orElseThrow(()->new RuntimeException("no hay ventas"));

        return new MayorVentaDTO(venta.getId(),venta.getTotal(),venta.getListaProductos().size(),venta.getCliente().getNombre(),venta.getCliente().getApellido());
    }

}
