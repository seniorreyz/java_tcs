package com.pichincha.ejercicio.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pichincha.ejercicio.dto.CuentaDto;
import com.pichincha.ejercicio.exception.ResourceNotFoundException;
import com.pichincha.ejercicio.model.Cuenta;
import com.pichincha.ejercicio.repository.CuentaRepo;
import com.pichincha.ejercicio.services.CuentaService;

@Service
public class CuentaServiceImpl implements CuentaService {

	@Autowired
	private CuentaRepo cuentaRepo;

	public List<CuentaDto> getCuentas() {
		List<Cuenta> cuentas = cuentaRepo.findAll();
		return cuentas.stream().map(c -> c.toDto()).collect(Collectors.toList());
	}

	public Optional<CuentaDto> getCuentaById(Long id) {
		Optional<Cuenta> cuenta = cuentaRepo.findById(id);
		Optional<CuentaDto> cuentaDto;
		if (cuenta.isPresent()) {

			cuentaDto = Optional.of(cuenta.get().toDto());
		} else {
			cuentaDto = Optional.empty();
		}
		return cuentaDto;
	}

	public CuentaDto saveCuenta(CuentaDto cuenta) {
		// TODO Auto-generated method stub
		return cuentaRepo.save(cuenta.toEntity()).toDto();
	}

	public CuentaDto updateCuenta(Long id, CuentaDto cuentaActualizada) throws ResourceNotFoundException {
		Optional<CuentaDto> cuentaDto = getCuentaById(id);
		if (cuentaDto.isPresent()) {
			Cuenta cuenta = cuentaDto.get().toEntity();
			cuenta.setNumeroCuenta(cuentaActualizada.getNumeroCuenta());
			cuenta.setCodigoProducto(cuentaActualizada.getCodigoProducto());
			cuenta.setTipoCuenta(cuentaActualizada.getTipoCuenta());
			return cuentaRepo.save(cuenta).toDto();
		} else {
			throw new ResourceNotFoundException("Object does not exists");
		}
	}

	public void deleteCuenta(Long id) throws ResourceNotFoundException {
		Optional<CuentaDto> cuenta = getCuentaById(id);
		if (cuenta.isPresent()) {
			cuentaRepo.deleteById(id);
		} else {
			throw new ResourceNotFoundException("Object does not exists");
		}

	}

}
