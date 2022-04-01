package com.pichincha.ejercicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pichincha.ejercicio.model.Cuenta;

@Repository
public interface CuentaRepo extends JpaRepository<Cuenta, Long> {

}
