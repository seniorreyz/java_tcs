package com.tcsbpchapter.cuentasymovimientosdemo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcsbpchapter.cuentasymovimientosdemo.entidades.ECuenta;

public interface CuentaRepositorio extends JpaRepository<ECuenta, Long> {

}
