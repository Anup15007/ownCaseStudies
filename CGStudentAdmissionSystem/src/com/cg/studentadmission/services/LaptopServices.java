package com.cg.studentadmission.services;

import java.util.List;

import com.cg.studentadmission.beans.Laptop;
import com.cg.studentadmission.exceptions.LaptopDetailsNotFoundException;

public interface LaptopServices {
	int acceptLaptopDetails(String laptopBrand);
	
	Laptop getLaptopDetails(int laptopId)throws LaptopDetailsNotFoundException;
	
	List<Laptop> getAllLaptopDetails();
}
