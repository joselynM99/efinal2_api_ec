package com.proyecto.web.service.to;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public class ProductoAgregarTO extends RepresentationModel<ProductoAgregarTO> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String codigo;
	
	private Integer cantidad;
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
