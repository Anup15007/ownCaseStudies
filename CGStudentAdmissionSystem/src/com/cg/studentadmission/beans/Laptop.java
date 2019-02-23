package com.cg.studentadmission.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Laptop {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int laptopId;
	private String laptopBrand;
	@ManyToOne
	private Student student;
	
	public Laptop() {}

	public Laptop(String laptopBrand) {
		super();
		this.laptopBrand = laptopBrand;
	}

	public Laptop(int laptopId, String laptopBrand) {
		super();
		this.laptopId = laptopId;
		this.laptopBrand = laptopBrand;
	}

	public Laptop(int laptopId, String laptopBrand, Student student) {
		super();
		this.laptopId = laptopId;
		this.laptopBrand = laptopBrand;
		this.student = student;
	}

	public int getLaptopId() {
		return laptopId;
	}

	public void setLaptopId(int laptopId) {
		this.laptopId = laptopId;
	}

	public String getLaptopBrand() {
		return laptopBrand;
	}

	public void setLaptopBrand(String laptopBrand) {
		this.laptopBrand = laptopBrand;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((laptopBrand == null) ? 0 : laptopBrand.hashCode());
		result = prime * result + laptopId;
		result = prime * result + ((student == null) ? 0 : student.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Laptop other = (Laptop) obj;
		if (laptopBrand == null) {
			if (other.laptopBrand != null)
				return false;
		} else if (!laptopBrand.equals(other.laptopBrand))
			return false;
		if (laptopId != other.laptopId)
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Laptop [laptopId=" + laptopId + ", laptopBrand=" + laptopBrand + ", student=" + student + "]";
	}
	
}
