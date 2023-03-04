package com.proyecto.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.web.service.IProductoService;
import com.proyecto.web.service.to.ProductoTo;

@RestController
@RequestMapping(path = "/productos")
@CrossOrigin
public class ProductoControllerRestFul {
	
	@Autowired
	private IProductoService productoService;
	
	@PostMapping
	public void registrarProducto(@RequestBody ProductoTo producto) {
		this.productoService.registrarProducto(producto);
	}
	
	@PutMapping(path = "/{codigo}")
	public void actualizarProducto(@PathVariable("codigo") String codigo) {
		this.productoService.actualizarProducto(codigo);
	}
	
	@GetMapping(path = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ProductoTo buscarProducto(@PathVariable("codigo") String codigo) {
		return this.productoService.buscarProducto(codigo);
	}

}
