package com.testTC.testTC.repository;

import com.testTC.testTC.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
    List<Venta> findByFechaVenta (LocalDate fecha);
    Optional<Venta> findTopByOrderByTotalDesc();
}
