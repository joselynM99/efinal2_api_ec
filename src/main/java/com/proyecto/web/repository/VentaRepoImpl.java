package com.proyecto.web.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.web.modelo.Venta;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class VentaRepoImpl implements IVentaRepo{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Venta venta) {
		this.entityManager.persist(venta);
		
	}

}
