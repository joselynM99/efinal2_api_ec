package com.proyecto.web.service;

import java.math.BigDecimal;

import com.proyecto.web.service.to.DetalleVentaTO;
import com.proyecto.web.service.to.ProductoAgregarTO;
import com.proyecto.web.service.to.VentaTO;

public interface IVentaService {

	
	DetalleVentaTO agregarCarrito(ProductoAgregarTO producto);
	
	BigDecimal realizarVenta(VentaTO venta);
	
	
}
