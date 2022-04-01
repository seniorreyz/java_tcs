package com.pichincha.ejercicio.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.pichincha.ejercicio.dto.CuentaDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cuenta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String numeroCuenta;
	private String codigoProducto;
	private String tipoCuenta;
	@JsonManagedReference
	@OneToMany(mappedBy = "cuenta")
	private List<Movimiento> movimientos;

	public CuentaDto toDto() {
		return new CuentaDto(id, numeroCuenta, codigoProducto, tipoCuenta, movimientos);
	}
}
