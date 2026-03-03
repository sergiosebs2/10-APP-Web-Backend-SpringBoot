package com.testTC.testTC.repository;

import com.testTC.testTC.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    Producto findByNombre(String nombre);
    List<Producto> findByCantidadDisponibleLessThan(Double cantidadDisponible);

}
