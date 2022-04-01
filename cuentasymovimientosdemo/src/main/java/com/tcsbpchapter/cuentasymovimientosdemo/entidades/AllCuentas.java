package com.tcsbpchapter.cuentasymovimientosdemo.entidades;

import java.util.List;

public class AllCuentas {

	private List<ECuenta> eCuentaList;
	private List<EMovimiento> eMovimientoList;
	public List<ECuenta> geteCuentaList() {
		return eCuentaList;
	}
	public void seteCuentaList(List<ECuenta> eCuentaList) {
		this.eCuentaList = eCuentaList;
	}
	public List<EMovimiento> geteMovimientoList() {
		return eMovimientoList;
	}
	public void seteMovimientoList(List<EMovimiento> eMovimientoList) {
		this.eMovimientoList = eMovimientoList;
	}
}
