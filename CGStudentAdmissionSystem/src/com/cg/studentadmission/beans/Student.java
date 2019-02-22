package com.cg.studentadmission.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	int studentId;
	int stuClass;
	String studentName;
	String address;
	public Student() {}	
	public Student(int stuClass, String studentName, String address) {
		this.stuClass = stuClass;
		this.studentName = studentName;
		this.address = address;
	}	
	public Student(int studentId, int stuClass, String studentName, String address) {
		super();
		this.studentId = studentId;
		this.stuClass = stuClass;
		this.studentName = studentName;
		this.address = address;
	}

	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getstuClass(){
		return stuClass;
	}
	public void setstuClass(int stuClass) {
		this.stuClass = stuClass;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + stuClass;
		result = prime * result + studentId;
		result = prime * result + ((studentName == null) ? 0 : studentName.hashCode());
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
		Student other = (Student) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (stuClass != other.stuClass)
			return false;
		if (studentId != other.studentId)
			return false;
		if (studentName == null) {
			if (other.studentName != null)
				return false;
		} else if (!studentName.equals(other.studentName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", stuClass=" + stuClass + ", studentName=" + studentName
				+ ", address=" + address + "]";
	}
}
