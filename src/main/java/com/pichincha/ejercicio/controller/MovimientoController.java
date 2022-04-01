package com.pichincha.ejercicio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pichincha.ejercicio.dto.MovimientoDto;
import com.pichincha.ejercicio.exception.ResourceNotFoundException;
import com.pichincha.ejercicio.services.MovimientoService;

@RestController
@RequestMapping("/api/v1/movimientos")
public class MovimientoController {

	@Autowired
	private MovimientoService movimientoService;
	
	@PostMapping
	public ResponseEntity<?> newMovimiento(@RequestBody MovimientoDto movimiento) {
		return ResponseEntity.status(HttpStatus.CREATED).body(movimientoService.saveMovimiento(movimiento));
	}
	
	@DeleteMapping("/{id}")
	private ResponseEntity<?> deleteMovimiento(@PathVariable("id") Long id) {

		try {
			movimientoService.deleteMovimiento(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (ResourceNotFoundException e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
