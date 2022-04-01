package com.tcsbpchapter.cuentasymovimientosdemo.servicios;

import java.util.List;

import com.tcsbpchapter.cuentasymovimientosdemo.entidades.Cuenta;
import com.tcsbpchapter.cuentasymovimientosdemo.entidades.Cuentas;

public interface CuentaServicios {

	    public Cuentas getCuentas();
		
		public Cuenta createCuenta(Cuenta cuenta);
				
		public List<Cuenta> updateCuenta(List<Cuenta> cuentas);
		
		public Cuenta getCuentabyId(long id);
		
		public Cuenta updateCuentabyId(Cuenta cuenta);
		
		public String deleteCuentabyId(long id);
}
