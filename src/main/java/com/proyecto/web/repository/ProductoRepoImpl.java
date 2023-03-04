package com.proyecto.web.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.web.modelo.Producto;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class ProductoRepoImpl implements IProductoRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Producto producto) {
		this.entityManager.persist(producto);
		
	}

	@Override
	public Producto buscarPorCodigo(String codigoBarras) {
		TypedQuery<Producto> myQuery = this.entityManager.createQuery("SELECT p FROM Producto p WHERE p.codigoBarras=:codigoBarras",
				Producto.class);

		myQuery.setParameter("codigoBarras", codigoBarras);

		try {
			return myQuery.getSingleResult();
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public void actualizar(Producto producto) {
		this.entityManager.merge(producto);
		
	}

}
