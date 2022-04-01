package com.pichincha.ejercicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pichincha.ejercicio.model.Movimiento;

@Repository
public interface MovimientoRepo  extends JpaRepository<Movimiento, Long> {

}
