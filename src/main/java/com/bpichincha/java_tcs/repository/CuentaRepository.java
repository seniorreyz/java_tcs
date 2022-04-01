package com.bpichincha.java_tcs.repository;

import com.bpichincha.java_tcs.models.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    public Optional<Cuenta> getByNumCuenta(String numCuenta);
}
