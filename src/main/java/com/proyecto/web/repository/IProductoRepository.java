package com.proyecto.web.repository;

import com.proyecto.web.modelo.Producto;

public interface IProductoRepository {

	void insertar(Producto producto);
	
	Producto buscarPorCodigo(String codigo);
	
	void actualizar(Producto producto);
}
