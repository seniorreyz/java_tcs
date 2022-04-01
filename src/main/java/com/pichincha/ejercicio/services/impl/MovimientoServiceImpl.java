package com.pichincha.ejercicio.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pichincha.ejercicio.dto.MovimientoDto;
import com.pichincha.ejercicio.exception.ResourceNotFoundException;
import com.pichincha.ejercicio.model.Movimiento;
import com.pichincha.ejercicio.repository.MovimientoRepo;
import com.pichincha.ejercicio.services.MovimientoService;

@Service
public class MovimientoServiceImpl implements MovimientoService {

	@Autowired
	private MovimientoRepo movimientoRepo;

	@Override
	public MovimientoDto saveMovimiento(MovimientoDto movimiento) {
		return movimientoRepo.save(movimiento.toEntity()).toDto();
	}

	@Override
	public void deleteMovimiento(Long id) throws ResourceNotFoundException {
		Optional<MovimientoDto> movimiento = getMovimientoById(id);
		if (movimiento.isPresent()) {
			movimientoRepo.deleteById(id);
		} else {
			throw new ResourceNotFoundException("Object does not exists");
		}
	}

	public Optional<MovimientoDto> getMovimientoById(Long id) {
		Optional<Movimiento> movimiento = movimientoRepo.findById(id);
		Optional<MovimientoDto> movimientoDto;
		if (movimiento.isPresent()) {

			movimientoDto = Optional.of(movimiento.get().toDto());
		} else {
			movimientoDto = Optional.empty();
		}
		return movimientoDto;
	}

}
