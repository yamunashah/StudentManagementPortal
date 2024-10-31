package com.studentapp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static List<Student> studentList;
	private static Scanner scan;
	public static void main(String[] args) {
		
		System.out.println("*********Student Management System**********");
		System.out.println("---------Welcome to the Portal------------");
		studentList= new ArrayList<Student>();
		scan= new Scanner(System.in);
		while(true)
		{
		System.out.println("Enter Options..");
		System.out.println("1. Enroll Student to the portal");
		System.out.println("2. Find  Student with StudentId");
		System.out.println("3. List Student detail");
		System.out.println("4. List Student Detail in Shorted Order");
		System.out.println("5. Exit");
		int option=scan.nextInt();
		switch(option)
		{
			case 1:
				enrollStudent(scan);
				break;
			case 2: 
				findStudentbyId(scan);
				break;
			case 3:
				printStudentDetail();
				break;
			case 4:
				sortByName();
				break;
			case 5:
				exit();
				break;
				
			default: System.out.println("Invalid option Selected!");
				
				
		}	
		}
		
//		Student s1= new Student("Priyanka Sharma",24,"S-901");
//		s1.enrollCourse("JAVA");
//		s1.printStudentInfo();
//		
//		Student s2= new Student("Shweta",33,"S-122");
//		s2.enrollCourse("JAVA");
//		s2.enrollCourse("DSA");
//		s2.printStudentInfo();
//		
//		Student s3= new Student("Bhakti",29,"S-203");
//		s3.enrollCourse("JAVA");
//		s3.enrollCourse("DSA");
//		s3.enrollCourse("Python");
//		s3.printStudentInfo();
//
		
//		
//		studentList.add(s1);
//		studentList.add(s2);
//		studentList.add(s3);
//		
//		Student result = findStudentbyId("S-102");
//		System.out.println("Student Found with ID "+ result);
//		
//		sortByName();
//		sortByID();
//		sortbyAge();
		
		

	}
	
	
private static void findStudentbyId(Scanner scan2) {
		// TODO Auto-generated method stub
	
		Student result = null;
		System.out.println("Enter Student ID");
		String studentId= scan2.next();
		try
		{
			result= studentList.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId))
					.findFirst().orElseThrow(() -> new RuntimeException(""));
		}
		catch(RuntimeException e)
		{
			System.err.println("Student with ID "+ studentId + " Not Found");
		}
		
		result.printStudentInfo();
		
	}


private static void exit() {
		System.out.println("Exit from the Console!");
		System.exit(0);
		
	}


private static void printStudentDetail() {
		if(studentList.size()>0)
		{
		for (Student student : studentList) {
			student.printStudentInfo();
		}
		}
		else
		{
			System.err.println("No Student Exist in the Stduent List");
		}
		
	}


private static void enrollStudent(Scanner scan2) {
	
		System.out.println("Enter Student Name: ");
		String name= scan.next();
		System.out.println("Enter Student Age: ");
		int age= scan.nextInt();
		System.out.println("Enter Student ID: ");
		String studentid= scan.next();
		
		Student newstudent= new Student(name,age,studentid);
		studentList.add(newstudent);
		System.out.println("Student Added Successfully!");
		while(true)
		{
			System.out.println("Enter Course..Type 'Done' to exit! ");
			String course= scan.next();
			if(course.equalsIgnoreCase("done"))
				{
					break;
				}
			newstudent.enrollCourse(course);
		}
		newstudent.printStudentInfo();
		
	
		
	}


//	private static void sortbyAge() {
//		Comparator<Student> comparebyage= new Comparator<Student>() {
//
//			@Override
//			public int compare(Student o1, Student o2) {
//				return o1.getAge() - o2.getAge();
//			}
//		
//			
//		};
//		Collections.sort(studentList, comparebyage);
//		System.out.println(studentList);
//		
//	}


//	private static void sortByID() {
//		Comparator<Student> comparebyID= (o1,o2) -> o1.getStudentId().compareTo(o2.getStudentId());
//		Collections.sort(studentList,comparebyID);
//		System.out.println(studentList);
//		
//	}


	private static void sortByName() {
		
		Comparator<Student> comparebyName= (o1,o2)-> o1.getName().compareTo(o2.getName());
//		Comparator<Student> comparebyName= new Comparator<Student>() {

//			@Override
//			public int compare(Student o1, Student o2) {
//				 
//				return o1.getName().compareTo(o2.getName());
//			}
//		};
		Collections.sort(studentList, comparebyName);
		System.out.println("Student Shorted List:"+ studentList);
		
		
	}



//	public static Student findStudentbyId(String studentId)
//	{
//		Student result = null;
//		try
//		{
//			result= studentList.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId))
//					.findFirst().orElseThrow(() -> new RuntimeException(""));
//		}
//		catch(RuntimeException e)
//		{
//			System.err.println("Student with ID "+ studentId + " Not Found");
//		}
//		
//		return result;
//	}
}
