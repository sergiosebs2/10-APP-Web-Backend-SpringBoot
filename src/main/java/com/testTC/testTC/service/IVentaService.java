package com.testTC.testTC.service;

import com.testTC.testTC.dto.*;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    VentaDTO crear(VentaDTO ventaDTO);
    List<VentaDTO> listar();
    void eliminar(Long id);
    VentaDTO modificar(Long id, VentaDTO ventaDTO);
    List<DetalleDTO> traerporId (Long id);
    ResumendiaDTO traerEstadisticaDia (LocalDate fecha);
    MayorVentaDTO traerMayorVenta();
}
