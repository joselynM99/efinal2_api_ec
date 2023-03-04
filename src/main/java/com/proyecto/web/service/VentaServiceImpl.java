package com.proyecto.web.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.web.modelo.DetalleVenta;
import com.proyecto.web.modelo.Producto;
import com.proyecto.web.modelo.Venta;
import com.proyecto.web.repository.IProductoRepository;
import com.proyecto.web.repository.IVentaRepo;
import com.proyecto.web.service.to.DetalleVentaTO;
import com.proyecto.web.service.to.ProductoAgregarTO;
import com.proyecto.web.service.to.VentaTO;

@Service
public class VentaServiceImpl implements IVentaService {

	@Autowired
	private IProductoRepository productoRepository;

	@Autowired
	private IVentaRepo ventaRepo;

	@Override
	public DetalleVentaTO agregarCarrito(ProductoAgregarTO producto) {
		Producto p = this.productoRepository.buscarPorCodigo(producto.getCodigo());
		System.out.println(producto.getCodigo());
		if (p.getStock() >= producto.getCantidad()) {
			DetalleVentaTO d = new DetalleVentaTO();
			d.setCantidad(producto.getCantidad());
			d.setCodigoBarras(producto.getCodigo());
			d.setNombre(p.getNombre());
			d.setPrecioUnitario(p.getPrecio());
			d.setSubtotal(p.getPrecio().multiply(new BigDecimal(producto.getCantidad())));
			return d;
		} else {
			return null;
		}

	}

	@Override
	public BigDecimal realizarVenta(VentaTO venta) {

		Venta v = new Venta();
		v.setCedulaCliente(venta.getCedula());
		v.setNumeroVenta(venta.getNumeroVenta());

		List<ProductoAgregarTO> lista = venta.getListaProd();

		List<DetalleVenta> listaF = new ArrayList<>();

		for (ProductoAgregarTO p : lista) {
			DetalleVenta d = new DetalleVenta();
			Producto producto = this.productoRepository.buscarPorCodigo(p.getCodigo());
			d.setCantidad(p.getCantidad());
			d.setPrecioUnitario(producto.getPrecio());
			d.setProducto(producto);
			d.setSubtotal(producto.getPrecio().multiply(new BigDecimal(p.getCantidad())));
			d.setVenta(v);
			listaF.add(d);
		}

		v.setDetalles(listaF);
		BigDecimal total = new BigDecimal(0);
		for (DetalleVenta d : listaF) {
			total = total.add(d.getSubtotal());
		}

		v.setTotalVenta(total);

		this.ventaRepo.insertar(v);
		
		return total;

	}

}
