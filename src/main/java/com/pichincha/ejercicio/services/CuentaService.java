package com.pichincha.ejercicio.services;

import java.util.List;
import java.util.Optional;

import com.pichincha.ejercicio.dto.CuentaDto;
import com.pichincha.ejercicio.exception.ResourceNotFoundException;

public interface CuentaService {

	public List<CuentaDto> getCuentas();

	public Optional<CuentaDto> getCuentaById(Long id);

	public CuentaDto saveCuenta(CuentaDto cuenta);

	public CuentaDto updateCuenta(Long id, CuentaDto cuentaActualizada) throws ResourceNotFoundException;

	public void deleteCuenta(Long id) throws ResourceNotFoundException;
}
