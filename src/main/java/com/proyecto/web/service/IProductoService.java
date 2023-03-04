package com.proyecto.web.service;

import com.proyecto.web.service.to.ProductoTo;

public interface IProductoService {
	
	void registrarProducto(ProductoTo producto);
	
	void actualizarProducto(String codigo);
	
	ProductoTo buscarProducto(String codigo);

}
