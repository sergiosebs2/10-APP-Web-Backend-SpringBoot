package com.testTC.testTC.mapper;

import com.testTC.testTC.dto.ClienteDTO;
import com.testTC.testTC.dto.DetalleDTO;
import com.testTC.testTC.dto.ProductoDTO;
import com.testTC.testTC.dto.VentaDTO;
import com.testTC.testTC.exception.ResourceNotFoundException;
import com.testTC.testTC.model.Cliente;
import com.testTC.testTC.model.DetalleItemVenta;
import com.testTC.testTC.model.Producto;
import com.testTC.testTC.model.Venta;


public class Mapper {

    public static ProductoDTO deProductoaDTO(Producto producto){
        if(producto == null) throw new ResourceNotFoundException("Producto no es valido!");
        return ProductoDTO.builder()
                .nombre(producto.getNombre())
                .marca(producto.getMarca())
                .costo(producto.getCosto())
                .cantidad_disponible(producto.getCantidadDisponible())
                .build();
    }
    public static DetalleDTO dedetalleaDTO(DetalleItemVenta detalleItemVenta){
        if(detalleItemVenta==null) throw new ResourceNotFoundException("Detalle no valido");
        return DetalleDTO.builder()
                .nombre_producto(detalleItemVenta.getProducto().getNombre())
                .cantidad(detalleItemVenta.getCantidad())
                .precio_unitario(detalleItemVenta.getPrecio_unitario())
                .build();
    }


    public static VentaDTO deVentaaDTO (Venta venta){
        if(venta == null) throw new ResourceNotFoundException("Venta no es valida!");
        return VentaDTO.builder()
                .total(venta.getTotal())
                .fecha_venta(venta.getFechaVenta())
                .id_cliente(venta.getUnCliente().getId())
                .listaDetalleItemDTO(
                    venta.getListaDetalleItem().stream().map(Mapper::dedetalleaDTO).toList()
                )
                .build();
    }
    public static ClienteDTO deClienteaDTO (Cliente cliente){
        if(cliente == null) throw new ResourceNotFoundException("Cliente no valido!");
        return ClienteDTO.builder()
                .nombre(cliente.getNombre())
                .apellido(cliente.getApellido())
                .dni(cliente.getDni())
                .build();
    }
}
