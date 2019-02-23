package com.cg.studentadmission.daoservices;

import java.util.List;

import com.cg.studentadmission.beans.Laptop;


public interface LaptopDAO {
	Laptop save(Laptop  laptop);
	boolean update(Laptop laptop);
	Laptop findOne(int laptopId);
	List<Laptop > findAll();
}
