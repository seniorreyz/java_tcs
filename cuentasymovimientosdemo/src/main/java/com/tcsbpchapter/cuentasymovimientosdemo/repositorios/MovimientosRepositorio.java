package com.tcsbpchapter.cuentasymovimientosdemo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcsbpchapter.cuentasymovimientosdemo.entidades.ECuenta;
import com.tcsbpchapter.cuentasymovimientosdemo.entidades.EMovimiento;

public interface MovimientosRepositorio extends JpaRepository<EMovimiento, Long> {

}
