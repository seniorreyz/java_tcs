package com.pichincha.ejercicio.services;

import java.util.Optional;

import com.pichincha.ejercicio.dto.MovimientoDto;
import com.pichincha.ejercicio.exception.ResourceNotFoundException;

public interface MovimientoService {

	public MovimientoDto saveMovimiento(MovimientoDto movimiento);

	public void deleteMovimiento(Long id) throws ResourceNotFoundException;

	public Optional<MovimientoDto> getMovimientoById(Long id);
}
