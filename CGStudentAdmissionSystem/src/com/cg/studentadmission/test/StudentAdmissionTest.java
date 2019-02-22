package com.cg.studentadmission.test;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.cg.studentadmission.beans.Student;
import com.cg.studentadmission.exceptions.StudentDetailsNotFoundException;
import com.cg.studentadmission.services.StudentServices;
import com.cg.studentadmission.services.StudentServicesImpl;
import com.cg.studentadmission.util.StudentAdmissionDBUtil;



public class StudentAdmissionTest {
	public static StudentServices services;
	
	@BeforeClass
	public static void setUpTestEnv() {
		services = new StudentServicesImpl();
	}
	@Before
	public void setUpTestData() {
		Student student1 = new Student(101, 7, "AnupBanerjee","Pune Hingewadi");
		Student student2 = new Student(102, 7, "KuldeepDangwal","Pune Hingewadi");
		
		StudentAdmissionDBUtil.students.put(student1.getStudentId(), student1);
		StudentAdmissionDBUtil.students.put(student2.getStudentId(),student2);
		
		StudentAdmissionDBUtil.STUDENT_ID_COUNTER=102;
	}
	@Test(expected=StudentDetailsNotFoundException.class)
	public void testGetStudentDetailsForInvalidStudentId() throws StudentDetailsNotFoundException{
		services.getStudentDetails(123);
	}
	
	@Test
	public void testGetStudentDetailsForValidAssociateId() throws StudentDetailsNotFoundException{
		Student expectedStudent= new Student(102, 7, "KuldeepDangwal","Pune Hingewadi");
		Student actualStudent = services.getStudentDetails(102);
		Assert.assertEquals(expectedStudent, actualStudent);
	}
	
	@Test
	public void testAcceptStudentDetailsForValidData(){
		int expectedId = 103;
		int actualId = services.acceptStudentDetails( 7, "manuSharma","Pune Hingewadi");
		Assert.assertEquals(expectedId, actualId);
	}
	
	@Test
	public void testGetAllStudentsDetails() {
		Student student1 = new Student(101, 7, "AnupBanerjee","Pune Hingewadi");
		Student student2 = new Student(102, 7, "KuldeepDangwal","Pune Hingewadi");
		
		ArrayList<Student> expectedStudentList = new ArrayList<Student>();
		expectedStudentList.add(student1);
		expectedStudentList.add(student2);
		ArrayList<Student>actualStudentList = (ArrayList<Student>) services.getAllStudentsDetails();
		Assert.assertEquals(expectedStudentList, actualStudentList);
	}
	@After
	public void tearDownTestData() {
		StudentAdmissionDBUtil.students.clear();
		StudentAdmissionDBUtil.STUDENT_ID_COUNTER=100;
	}
	@AfterClass
	public static void tearDownTestEnv() {
		services=null;
	}
	
}
