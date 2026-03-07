package com.testTC.testTC.service;

import com.testTC.testTC.dto.DetalleDTO;
import com.testTC.testTC.dto.MayorVentaDTO;
import com.testTC.testTC.dto.ResumendiaDTO;
import com.testTC.testTC.dto.VentaDTO;
import com.testTC.testTC.exception.ResourceNotFoundException;
import com.testTC.testTC.mapper.Mapper;
import com.testTC.testTC.model.DetalleItemVenta;
import com.testTC.testTC.model.Venta;
import com.testTC.testTC.repository.ClienteRepository;
import com.testTC.testTC.repository.ProductoRepository;
import com.testTC.testTC.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VentaService implements IVentaService{
    @Autowired
    VentaRepository repoVenta;
    @Autowired
    ProductoRepository repoProducto;
    @Autowired
    ClienteRepository repoCliente;

    @Override
    public VentaDTO crear(VentaDTO ventaDTO) {
        if(ventaDTO == null ) throw new ResourceNotFoundException("No existe ventaDTO");
        //crear venta
        Venta venta = new Venta();
        venta.setFechaVenta(ventaDTO.getFecha_venta());
        venta.setTotal(ventaDTO.getTotal());
        //asignar lista
        venta.setListaDetalleItem(
                ventaDTO.getListaDetalleItemDTO().stream().map(det->
                        DetalleItemVenta.builder()
                                .cantidad(det.getCantidad())
                                .precio_unitario(det.getPrecio_unitario())
                                .producto(repoProducto.findByNombre(det.getNombre_producto()))
                                .venta(venta)
                                .build()
                ).toList()
        );

        //asignar cliente
        venta.setUnCliente(repoCliente.findById(ventaDTO.getId_cliente()).orElseThrow(()->new ResourceNotFoundException("Cliente XX")));
        return Mapper.deVentaaDTO(repoVenta.save(venta));
    }

    @Override
    public List<VentaDTO> listar() {
        return repoVenta.findAll().stream().map(Mapper::deVentaaDTO).toList();
    }

    @Override
    public void eliminar(Long id) {
        if(repoVenta.existsById(id)) repoVenta.deleteById(id);
        else throw new ResourceNotFoundException("Id no existe en la BD");
    }

    @Override
    public VentaDTO modificar(Long id, VentaDTO ventaDTO) {
        return null;
    }

    @Override
    public List<DetalleDTO> traerporId(Long id) {
        Venta venta = repoVenta.findById(id).orElseThrow(()->new ResourceNotFoundException("No existe el id"));
        return venta.getListaDetalleItem().stream().map(Mapper::dedetalleaDTO).toList();
    }

    @Override
    public ResumendiaDTO traerEstadisticaDia(LocalDate fecha) {
        List<Venta> lista = repoVenta.findByFechaVenta(fecha);
        double montoTotal = lista.stream()
                .mapToDouble(Venta::getTotal)
                .sum();
        return ResumendiaDTO.builder()
                .ventasTotal(lista.size())
                .recaudacionTotal(montoTotal)
                .build();
    }

    @Override
    public MayorVentaDTO traerMayorVenta() {
        Venta venta = repoVenta.findTopByOrderByTotalDesc();
        return MayorVentaDTO.builder()
                .codigoVenta(venta.getCodigoVenta())
                .nombre(venta.getUnCliente().getNombre())
                .apellido(venta.getUnCliente().getApellido())
                .cantidadProductos(venta.getListaDetalleItem().size())
                .monto(venta.getTotal())
                .build();
    }
}
