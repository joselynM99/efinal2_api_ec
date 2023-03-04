package com.proyecto.web.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.web.service.IVentaService;
import com.proyecto.web.service.to.DetalleVentaTO;
import com.proyecto.web.service.to.ProductoAgregarTO;
import com.proyecto.web.service.to.VentaTO;

@RestController
@RequestMapping(path = "/ventas")
@CrossOrigin
public class VentaControllerRestFul {

	@Autowired
	private IVentaService ventaService;

	@PostMapping(path = "/agregarProducto", produces = { MediaType.APPLICATION_JSON_VALUE })
	public DetalleVentaTO agregarCarrito(@RequestBody ProductoAgregarTO producto) {
		
		System.out.println("C"+producto.getCodigo());
		return this.ventaService.agregarCarrito(producto);
	}

	@PostMapping
	public BigDecimal realizarVenta(@RequestBody VentaTO venta) {
		return this.ventaService.realizarVenta(venta);

	}

}
