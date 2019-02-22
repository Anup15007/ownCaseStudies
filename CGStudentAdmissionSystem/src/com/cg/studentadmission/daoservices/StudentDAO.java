package com.cg.studentadmission.daoservices;

import java.util.List;

import com.cg.studentadmission.beans.Student;

public interface StudentDAO {
	Student save(Student  student);
	boolean update(Student student);
	Student findOne(int studentId);
	List<Student > findAll();

}
