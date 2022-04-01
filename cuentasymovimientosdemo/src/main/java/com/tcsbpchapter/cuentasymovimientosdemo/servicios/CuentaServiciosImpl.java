package com.tcsbpchapter.cuentasymovimientosdemo.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcsbpchapter.cuentasymovimientosdemo.entidades.AllCuentas;
import com.tcsbpchapter.cuentasymovimientosdemo.entidades.Cuenta;
import com.tcsbpchapter.cuentasymovimientosdemo.entidades.Cuentas;
import com.tcsbpchapter.cuentasymovimientosdemo.entidades.ECuenta;
import com.tcsbpchapter.cuentasymovimientosdemo.entidades.EMovimiento;
import com.tcsbpchapter.cuentasymovimientosdemo.repositorios.CuentaRepositorio;

import com.tcsbpchapter.cuentasymovimientosdemo.repositorios.MovimientosRepositorio;

@Service
public class CuentaServiciosImpl implements CuentaServicios{

	@Autowired
	CuentaRepositorio cuentaRepositorio;
	MovimientosRepositorio movimientosRepositorio;
	
	@Override
	public Cuentas getCuentas() {
		// TODO Auto-generated method stub
		List<ECuenta> cuentas=cuentaRepositorio.findAll();
		List<EMovimiento> movimentos=movimientosRepositorio.findAll();
		List<Cuenta> cuentasList = new ArrayList<Cuenta>();
		Cuentas cuentas1 = new Cuentas();
		for(ECuenta var1 : cuentas){
			for(EMovimiento var2 : movimentos)
			{
			if(var1.getCustomerId()==var2.getCustomerId()) {
			Cuenta all =new Cuenta();
			all.setCustomerId(var1.getCustomerId());
			all.setAccountNumber(var1.getAccountNumber());
			all.setCustomerName(var1.getCustomerName());
			all.setCredit(var2.getCredit());
			all.setDebit(var2.getCredit());
			all.setDescription(var1.getDescription());
			all.setRemarks(var2.getRemarks());
			cuentasList.add(all);
			}
			}
		}
		cuentas1.seteCuentaList(cuentasList);
		return cuentas1;
	}

	@Override
	public Cuenta createCuenta(Cuenta cuenta) {
		// TODO Auto-generated method stub
		ECuenta ecuenta = new ECuenta();
		ecuenta.setAccountNumber(cuenta.getAccountNumber());
		ecuenta.setCustomerName(cuenta.getCustomerName());
		ecuenta.setDescription(cuenta.getDescription());
		
		EMovimiento emovi= new EMovimiento();
		emovi.setCustomerId(cuenta.getCustomerId());
		emovi.setCredit(cuenta.getCredit());
		emovi.setDebit(cuenta.getDebit());
		emovi.setRemarks(cuenta.getRemarks());
		
		cuentaRepositorio.save(ecuenta);
		movimientosRepositorio.save(emovi);
		
		
		return cuenta;
	}

	@Override
	public List<Cuenta> updateCuenta(List<Cuenta> cuentas) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cuenta getCuentabyId(long id) {
		ECuenta cuenta=cuentaRepositorio.findById(id).orElse(null);
		EMovimiento movimiento=movimientosRepositorio.findById(id).orElse(null);
		Cuenta cuentas = new Cuenta();
		cuentas.setAccountNumber(cuenta.getAccountNumber());
		cuentas.setCustomerName(cuenta.getCustomerName());
		cuentas.setCredit(movimiento.getCredit());
		cuentas.setDebit(movimiento.getDebit());
		cuentas.setDescription(cuenta.getDescription());
		cuentas.setRemarks(movimiento.getRemarks());
		return cuentas;
	}

	@Override
	public Cuenta updateCuentabyId(Cuenta cuenta) {
		// TODO Auto-generated method stub
		ECuenta ecuenta=new ECuenta();
		ecuenta.setCustomerId(cuenta.getCustomerId());
		Optional<ECuenta> oldECuenta = cuentaRepositorio.findById(cuenta.getCustomerId());
		if(!oldECuenta.isEmpty() && oldECuenta.isPresent())
		{
			ECuenta oldCuenta = oldECuenta.get();
			oldCuenta.setAccountNumber(cuenta.getAccountNumber());
			oldCuenta.setCustomerName(cuenta.getCustomerName());
			oldCuenta.setDescription(cuenta.getDescription());
			cuentaRepositorio.save(oldCuenta);
		}
		EMovimiento movimiento = new EMovimiento();
		movimiento.setCustomerId(cuenta.getCustomerId());
		Optional<EMovimiento> old = movimientosRepositorio.findById(movimiento.getCustomerId());
		if(!old.isEmpty() && old.isPresent())
		{
			EMovimiento newMovimientos = old.get();
			newMovimientos.setCredit(movimiento.getDebit());
			newMovimientos.setDebit(movimiento.getDebit());
			newMovimientos.setRemarks(movimiento.getRemarks());
			movimientosRepositorio.save(movimiento);
		}
		return cuenta;
	}

	@Override
	public String deleteCuentabyId(long id) {
		// TODO Auto-generated method stub
		cuentaRepositorio.deleteById(id);
		movimientosRepositorio.deleteById(id);
		return "Record deleted sucessfully";
	}

  
}
