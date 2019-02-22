package com.cg.studentadmission.util;

import java.util.HashMap;

import com.cg.studentadmission.beans.Student;


public class StudentAdmissionDBUtil {
	public static HashMap<Integer, Student> students = new HashMap<Integer, Student>();
	
	public static int STUDENT_ID_COUNTER=100;
	
	public static int getSTUDENT_ID_COUNTER() {
		return ++STUDENT_ID_COUNTER;
	}
}
