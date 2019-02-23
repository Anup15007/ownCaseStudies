package com.cg.studentadmission.services;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.studentadmission.beans.Laptop;
import com.cg.studentadmission.daoservices.LaptopDAO;
import com.cg.studentadmission.daoservices.LaptopDAOImpl;
import com.cg.studentadmission.exceptions.LaptopDetailsNotFoundException;

public class LaptopServicesImpl implements LaptopServices{
	private LaptopDAO laptopDao = new LaptopDAOImpl();
	EntityManagerFactory  entityManagerFactory=Persistence.createEntityManagerFactory("JPA-PU");
	@Override
	public int acceptLaptopDetails(String laptopBrand) {
		
		Laptop laptop = new Laptop(   laptopBrand);
		
		laptop = laptopDao.save(laptop);
		return laptop.getLaptopId();

	}

	@Override
	public Laptop getLaptopDetails(int laptopId) throws LaptopDetailsNotFoundException {
		Laptop laptop = laptopDao.findOne(laptopId);
		if(laptop==null)
			throw new LaptopDetailsNotFoundException("Laptop details not found for id = "+laptopId);
		
		return laptop;
	}

	@Override
	public List<Laptop> getAllLaptopDetails() {
		return laptopDao.findAll();
	}

}
