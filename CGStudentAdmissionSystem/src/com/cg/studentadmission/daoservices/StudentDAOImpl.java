package com.cg.studentadmission.daoservices;

import java.util.ArrayList;
import java.util.List;


import com.cg.studentadmission.beans.Student;
import com.cg.studentadmission.util.StudentAdmissionDBUtil;

public class StudentDAOImpl implements StudentDAO{

	@Override
	public Student save(Student student) {
	student.setStudentId(StudentAdmissionDBUtil.getSTUDENT_ID_COUNTER());
	StudentAdmissionDBUtil.students.put(student.getStudentId(),student);
		return student;
	}

	@Override
	public boolean update(Student student) {
	
		return false;
	}

	@Override
	public Student findOne(int studentId) {
		return StudentAdmissionDBUtil.students.get(studentId);
	}

	@Override
	public List<Student> findAll() {
		ArrayList<Student> studentList = new ArrayList<Student>(StudentAdmissionDBUtil.students.values());
		return studentList;
	}

}
