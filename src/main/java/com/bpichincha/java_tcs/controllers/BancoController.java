package com.bpichincha.java_tcs.controllers;

import com.bpichincha.java_tcs.models.Cuenta;
import com.bpichincha.java_tcs.models.Movimiento;
import com.bpichincha.java_tcs.services.CuentaService;
import com.bpichincha.java_tcs.services.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class BancoController {
    @Autowired
    private CuentaService cuentaService;

    @Autowired
    private MovimientoService movimientoService;

    @GetMapping("/cuentas")
    private ResponseEntity<List<Cuenta>> getCuentas() {
        return new ResponseEntity<>(cuentaService.getCuentas(), HttpStatus.OK);
    }

    @PostMapping("/cuentas")
    private ResponseEntity<Cuenta> addCuenta(@RequestBody Cuenta cuenta) {
        return new ResponseEntity<>(cuentaService.addCuenta(cuenta), HttpStatus.OK);
    }

    @GetMapping("cuenta/{id}")
    private ResponseEntity<Cuenta> getCuenta(@PathVariable Long id) {
        Optional<Cuenta> cuentaOptional = cuentaService.getCuenta(id);

        if (cuentaOptional.isPresent())
            return new ResponseEntity<>(cuentaOptional.get(), HttpStatus.OK);
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cuenta no existe");
    }

    @PutMapping("cuenta/{id}")
    private ResponseEntity<Cuenta> editCuenta(@PathVariable Long id, @RequestBody Cuenta cuenta) {
        Optional<Cuenta> cuentaOptional = cuentaService.editCuenta(id, cuenta);

        if (cuentaOptional.isPresent())
            return new ResponseEntity<>(cuentaOptional.get(), HttpStatus.OK);
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontrado cuenta");
    }

    @PostMapping("cuenta/{numCuenta}/depositar")
    private ResponseEntity<Movimiento> depositar(@PathVariable String numCuenta, @RequestBody Movimiento movimiento) {
        Optional<Movimiento> movimientoOptional = movimientoService.depositar(numCuenta, movimiento);

        if (movimientoOptional.isPresent())
            return new ResponseEntity<>(movimientoOptional.get(), HttpStatus.OK);
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cuenta no existe");
    }

    @GetMapping("cuenta/{numCuenta}/movimientos")
    private ResponseEntity<List<Movimiento>> getMovimientos(@PathVariable String numCuenta) {
        return new ResponseEntity<>(movimientoService.getMovimientos(numCuenta), HttpStatus.ACCEPTED);
    }
}
