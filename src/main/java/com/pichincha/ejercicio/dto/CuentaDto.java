package com.pichincha.ejercicio.dto;

import java.util.List;

import com.pichincha.ejercicio.model.Cuenta;
import com.pichincha.ejercicio.model.Movimiento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CuentaDto {
	private Long id;
	private String numeroCuenta;
	private String codigoProducto;
	private String tipoCuenta;
	private List<Movimiento> movimientos;

	public Cuenta toEntity() {
		return new Cuenta(id, numeroCuenta, codigoProducto, tipoCuenta, movimientos);
	}
}
