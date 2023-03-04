package com.proyecto.web.service.to;

import java.io.Serializable;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

public class VentaTO extends RepresentationModel< VentaTO> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String numeroVenta;
	private String cedula;
	private List<ProductoAgregarTO> listaProd;
	public String getNumeroVenta() {
		return numeroVenta;
	}
	public void setNumeroVenta(String numeroVenta) {
		this.numeroVenta = numeroVenta;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public List<ProductoAgregarTO> getListaProd() {
		return listaProd;
	}
	public void setListaProd(List<ProductoAgregarTO> listaProd) {
		this.listaProd = listaProd;
	}
	
	

}
