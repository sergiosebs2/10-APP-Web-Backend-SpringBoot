package com.testTC.testTC.service;

import com.testTC.testTC.dto.ProductoDTO;
import com.testTC.testTC.dto.VentaDTO;

import java.util.List;

public interface IProductoService {

    ProductoDTO crear(ProductoDTO productoDTO);
    List<ProductoDTO> listar();
    void eliminar(Long id);
    ProductoDTO modificar(Long id, ProductoDTO productoDTO);
    List<ProductoDTO> filtrarXcantidad (Double cantidad);
}
