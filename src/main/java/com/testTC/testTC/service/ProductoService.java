package com.testTC.testTC.service;

import com.testTC.testTC.dto.ProductoDTO;
import com.testTC.testTC.exception.ResourceNotFoundException;
import com.testTC.testTC.mapper.Mapper;
import com.testTC.testTC.model.Producto;
import com.testTC.testTC.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {
    @Autowired
    ProductoRepository repoProducto;

    @Override
    public ProductoDTO crear(ProductoDTO productoDTO) {
        Producto producto = Producto.builder()
                .nombre(productoDTO.getNombre())
                .costo(productoDTO.getCosto())
                .marca(productoDTO.getMarca())
                .cantidadDisponible(productoDTO.getCantidad_disponible())
                .build();
        return Mapper.deProductoaDTO(repoProducto.save(producto));
    }

    @Override
    public List<ProductoDTO> listar() {
        return repoProducto.findAll().stream().map(Mapper::deProductoaDTO).toList();
    }

    @Override
    public void eliminar(Long id) {
        if (repoProducto.existsById(id)) repoProducto.deleteById(id);
        else throw new ResourceNotFoundException("Id no existe en la base de datos");
    }

    @Override
    public ProductoDTO modificar(Long id, ProductoDTO productoDTO) {
        Producto producto = repoProducto.findById(id).orElseThrow(() -> new ResourceNotFoundException("No existe en la BD"));
        if (productoDTO.getNombre() != null) producto.setNombre(productoDTO.getNombre());
        if (productoDTO.getCosto() != null) producto.setCosto(productoDTO.getCosto());
        if (productoDTO.getMarca() != null) producto.setMarca(productoDTO.getMarca());
        if (productoDTO.getCantidad_disponible() != null)
            producto.setCantidadDisponible(productoDTO.getCantidad_disponible());
        return Mapper.deProductoaDTO(repoProducto.save(producto));

    }

    @Override
    public List<ProductoDTO> filtrarXcantidad(Double cantidad) {
       return repoProducto.findByCantidadDisponibleLessThan(cantidad).stream().map(Mapper::deProductoaDTO).toList();
    }
}