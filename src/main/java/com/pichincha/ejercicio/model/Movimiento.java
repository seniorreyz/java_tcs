package com.pichincha.ejercicio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pichincha.ejercicio.dto.MovimientoDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movimiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fecha;
	private Float valor;
	private String tipo;
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="cuenta_id")
	private Cuenta cuenta;
	
	public MovimientoDto toDto() 
	{
		return new MovimientoDto(id, fecha, valor, tipo, cuenta.toDto());
	}
}
