package com.tcsbpchapter.cuentasymovimientosdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcsbpchapter.cuentasymovimientosdemo.entidades.Cuenta;
import com.tcsbpchapter.cuentasymovimientosdemo.entidades.Cuentas;
import com.tcsbpchapter.cuentasymovimientosdemo.servicios.CuentaServicios;


@RestController
public class CuentasyMovimientosController {

	@Autowired
	private CuentaServicios cuentaServicios;
	
	@GetMapping
	@RequestMapping(value = "/getcuentas" , method = RequestMethod.GET)
	public Cuentas getCuentas()
	{
		return cuentaServicios.getCuentas();
	}
	
	@PostMapping
	@RequestMapping(value = "/createcuenta" , method = RequestMethod.POST)
	public Cuenta createCuenta(@RequestBody Cuenta cuenta)
	{
		return cuentaServicios.createCuenta(cuenta);
	}
	

	@GetMapping
	@RequestMapping(value = "/getcuentabyid/{id}" , method = RequestMethod.GET)
	public Cuenta getCuentabyId(@PathVariable("id") long id)
	{
		return cuentaServicios.getCuentabyId(id);
	}
	
	@GetMapping
	@RequestMapping(value = "/updatecuenta/{id}" , method = RequestMethod.GET)
	public Cuenta updateBooksbyId(@RequestBody Cuenta cuenta)
	{
		return cuentaServicios.updateCuentabyId(cuenta);
	}
	
	@GetMapping
	@RequestMapping(value = "/deletecuenta/{id}" , method = RequestMethod.GET)
	public Cuenta deleteBookbyId(@PathVariable("id") long id)
	{
		Cuenta cuenta = new Cuenta();
		cuenta.setCustomerId(id);
		cuenta.setRemarks(cuentaServicios.deleteCuentabyId(id));
		cuenta.setDescription(id + "Deleted");
		return cuenta;	
	}
}
