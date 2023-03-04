package com.proyecto.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.web.modelo.Producto;
import com.proyecto.web.repository.IProductoRepository;
import com.proyecto.web.service.to.ProductoTo;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepository productoRepository;

	@Override
	public void registrarProducto(ProductoTo producto) {
		
		Producto p = this.productoRepository.buscarPorCodigo(producto.getCodigoBarras());
		
		
		if(p==null) {
			this.productoRepository.insertar(this.convertirAProducto(producto));
			System.out.println("L" +producto.getCodigoBarras());
		}else {
			p.setStock(p.getStock()+producto.getStock());
			p.setCategoria(producto.getCategoria());
			p.setCodigoBarras(producto.getCodigoBarras());
			System.out.println(producto.getCodigoBarras());
			p.setId(p.getId());
			p.setNombre(producto.getNombre());
			p.setPrecio(producto.getPrecio());
			this.productoRepository.actualizar(p);
			
		}
		

	}

	@Override
	public void actualizarProducto(String codigo) {

		this.productoRepository.actualizar(this.productoRepository.buscarPorCodigo(codigo));

	}

	@Override
	public ProductoTo buscarProducto(String codigo) {
		
		return this.convertirAProductoTO(this.productoRepository.buscarPorCodigo(codigo));
	}

	private ProductoTo convertirAProductoTO(Producto p) {
		ProductoTo pr = new ProductoTo();
		pr.setCategoria(p.getCategoria());
		pr.setCodigoBarras(p.getCodigoBarras());
		pr.setNombre(p.getNombre());
		pr.setPrecio(p.getPrecio());
		pr.setStock(p.getStock());
		return pr;
	}

	private Producto convertirAProducto(ProductoTo p) {
		Producto pr = new Producto();
		pr.setCategoria(p.getCategoria());
		pr.setCodigoBarras(p.getCodigoBarras());
		pr.setNombre(p.getNombre());
		pr.setPrecio(p.getPrecio());
		pr.setStock(p.getStock());
		return pr;
	}
}
