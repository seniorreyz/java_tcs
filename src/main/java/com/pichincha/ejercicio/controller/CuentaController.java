package com.pichincha.ejercicio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pichincha.ejercicio.dto.CuentaDto;
import com.pichincha.ejercicio.exception.ResourceNotFoundException;
import com.pichincha.ejercicio.services.CuentaService;

@RestController
@RequestMapping("/api/v1/cuentas")
public class CuentaController {

	@Autowired
	public CuentaService cuentaService;

	@GetMapping
	public List<CuentaDto> allCuentas() {
		return cuentaService.getCuentas();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> oneCuentaById(@PathVariable("id") Long id) {
		Optional<CuentaDto> cuenta = cuentaService.getCuentaById(id);
		if (cuenta.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(cuenta);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<?> newCuenta(@RequestBody CuentaDto cuenta) {
		return ResponseEntity.status(HttpStatus.CREATED).body(cuentaService.saveCuenta(cuenta));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateCuenta(@RequestBody CuentaDto cuentaActualizada, @PathVariable("id") Long id) {
		try {			
			return ResponseEntity.status(HttpStatus.OK).body(cuentaService.updateCuenta(id, cuentaActualizada));
		} catch (ResourceNotFoundException e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	private ResponseEntity<?> deleteCuenta(@PathVariable("id") Long id) {

		try {
			cuentaService.deleteCuenta(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (ResourceNotFoundException e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
