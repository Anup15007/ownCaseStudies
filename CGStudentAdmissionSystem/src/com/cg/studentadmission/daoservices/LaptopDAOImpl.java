package com.cg.studentadmission.daoservices;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.studentadmission.beans.Laptop;

public class LaptopDAOImpl implements LaptopDAO{
	private EntityManagerFactory  entityManagerFactory =Persistence.createEntityManagerFactory("JPA-PU");

	@Override
	public Laptop save(Laptop laptop) {
		EntityManager   entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(laptop);
		entityManager.getTransaction().commit();
		entityManager.close();
		return laptop;
	}

	@Override
	public boolean update(Laptop laptop) {
		EntityManager   entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(laptop);
		entityManager.getTransaction().commit();
		entityManager.close();
		return false;
	}

	@Override
	public Laptop findOne(int laptopId) {
		return entityManagerFactory.createEntityManager().find(Laptop.class, laptopId);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Laptop> findAll() {
		Query query=entityManagerFactory.createEntityManager().createQuery("from Laptop l");
		return query.getResultList();
	}

}
