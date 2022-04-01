package com.bpichincha.java_tcs.services;

import com.bpichincha.java_tcs.models.Cuenta;
import com.bpichincha.java_tcs.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaService {
    @Autowired
    private CuentaRepository cuentaRepository;

    public List<Cuenta> getCuentas() {
        return cuentaRepository.findAll();
    }

    public Cuenta addCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public Optional<Cuenta> getCuenta(Long id) {
        return cuentaRepository.findById(id);
    }

    public Optional<Cuenta> editCuenta( Long id, Cuenta cuenta ) {
        Optional<Cuenta> cuentaOptional = cuentaRepository.findById(id);

        if (cuentaOptional.isEmpty()) {
            return cuentaOptional;
        }

        Cuenta cuentaInterna = cuentaOptional.get();
        cuentaInterna.setPropietario(cuenta.getPropietario());

        return Optional.of(cuentaRepository.save(cuentaInterna));
    }
}
