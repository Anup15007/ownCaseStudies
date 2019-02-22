package com.cg.studentadmission.services;

import java.util.List;

import com.cg.studentadmission.beans.Student;
import com.cg.studentadmission.daoservices.StudentDAO;
import com.cg.studentadmission.daoservices.StudentDAOImpl;
import com.cg.studentadmission.exceptions.StudentDetailsNotFoundException;

public class StudentServicesImpl implements StudentServices{
	private StudentDAO studentDao = new StudentDAOImpl();
	@Override
	public int acceptStudentDetails( int stuClass, String studentName, String address) {
		Student student = new Student(  stuClass,  studentName,  address);
		
		student = studentDao.save(student);
		return student.getStudentId();
	}

	@Override
	public Student getStudentDetails(int studentId) throws StudentDetailsNotFoundException {
		Student student = studentDao.findOne(studentId);
		if(student==null)
			throw new StudentDetailsNotFoundException("Associate details not found for id = "+studentId);
		
		return student;
	}

	@Override
	public List<Student> getAllStudentsDetails() {
		
		return studentDao.findAll();
	}
	

}
