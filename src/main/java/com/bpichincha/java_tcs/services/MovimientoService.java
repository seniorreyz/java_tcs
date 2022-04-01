package com.bpichincha.java_tcs.services;

import com.bpichincha.java_tcs.models.Cuenta;
import com.bpichincha.java_tcs.models.Movimiento;
import com.bpichincha.java_tcs.repository.CuentaRepository;
import com.bpichincha.java_tcs.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovimientoService {
    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private MovimientoRepository movimientoRepository;

    public Optional<Movimiento> depositar( String numCuenta, Movimiento movimiento ) {
        Optional<Cuenta> cuentaOptional = cuentaRepository.getByNumCuenta(numCuenta);

        if(cuentaOptional.isEmpty())
            return Optional.empty();

        Movimiento movimientoNuevo = new Movimiento();
        movimientoNuevo.setCuenta(cuentaOptional.get());
        movimientoNuevo.setValor(movimiento.getValor());
        movimientoNuevo.setFecha(Calendar.getInstance().getTime());
        movimientoNuevo.setDescripcion(movimiento.getDescripcion());

        return Optional.of(movimientoRepository.save(movimientoNuevo));
    }

    public List<Movimiento> getMovimientos( String numCuenta ){
        return movimientoRepository.findAll().stream().
                filter(movimiento -> movimiento.getCuenta().getNumCuenta().compareTo(numCuenta) == 0).
                collect(Collectors.toList());
    }
}
