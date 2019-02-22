package com.cg.studentadmission.services;

import java.util.List;

import com.cg.studentadmission.beans.Student;
import com.cg.studentadmission.exceptions.StudentDetailsNotFoundException;

public interface StudentServices {
	int acceptStudentDetails( int stuClass, String studentName, String address);
	
	Student getStudentDetails(int studentId)throws StudentDetailsNotFoundException;
	
	List<Student> getAllStudentsDetails();

}
