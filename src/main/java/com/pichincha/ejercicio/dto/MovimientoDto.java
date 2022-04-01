package com.pichincha.ejercicio.dto;

import com.pichincha.ejercicio.model.Movimiento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovimientoDto {
	private Long id;
	private String fecha;
	private Float valor;
	private String tipo;
	private CuentaDto cuenta;
	
	public Movimiento toEntity() 
	{
		return new Movimiento(id, fecha, valor, tipo, cuenta.toEntity());
	}
}
