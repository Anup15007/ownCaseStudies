package com.cg.studentadmission.client;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.studentadmission.beans.Laptop;
import com.cg.studentadmission.beans.Student;
import com.cg.studentadmission.services.LaptopServices;
import com.cg.studentadmission.services.LaptopServicesImpl;
import com.cg.studentadmission.services.StudentServices;
import com.cg.studentadmission.services.StudentServicesImpl;
public class MainClass {

	public static void main(String[] args) {

		
		StudentServices services = new StudentServicesImpl();
		LaptopServices lservices=new LaptopServicesImpl();
		Scanner sc = new Scanner(System.in);			
		System.out.println("******************StudentDetails********************");
		char ch='y';
		while(ch=='y'||ch=='Y') {
			System.out.println("Enter your choice:\n1. Save Student\n2. Get Student Details\n3. Get All Student Details");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Student Name: ");
				String studName = sc.next();
				System.out.println("Student Class: ");
				int studClass = sc.nextInt();
				System.out.println("Student Address: ");
				String studAddress = sc.next();
				System.out.println("Enter laptop brand");
				String laptopBrand=sc.next();
				int studentId=services.acceptStudentDetails(studClass, studName,studAddress);
				System.out.println("Student Id: "+studentId);
				int laptopId=lservices.acceptLaptopDetails( laptopBrand);
				System.out.println("Laptop Id:"+laptopId);
				
				break;
			case 2: 
				System.out.println("Enter student id and laptop id respectively to find details: ");
				int id = sc.nextInt();
				int lId=sc.nextInt();
				Student studentDetails = services.getStudentDetails(id);
				Laptop laptopDetails=lservices.getLaptopDetails(lId);
				System.out.println(studentDetails);
				System.out.println(laptopDetails);
				break;
			case 3:
				//List<Student> allStudentDetails = services.getAllStudentsDetails();		
				System.out.println(services.getAllStudentsDetails());
				List<Laptop>allLaptopDetails=lservices.getAllLaptopDetails();
				System.out.println(allLaptopDetails);
				break;
			default:
				System.out.println("Please enter a valid number");
				break;
			}
			System.out.println("Do you want to continue(y/n): ");
			ch = sc.next().charAt(0);
		}
	}
}
