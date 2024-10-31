package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
	
	//Instance Variable(always be non-static)
	 private String name;
	 private int age;
	 private String studentId;
	 private List<String> courses;
	 
	 
	public Student(String name, int age, String studentId) {
		super();
		if(validateAge(age) && validateName(name) && validateStudentId(studentId))
		{
			this.name = name;
			this.age = age;
			this.studentId = studentId;
			courses = new ArrayList<String>();
		}
	}
	
	public void enrollCourse(String course)
	{
		if(validateCourseName(course))
		{
			if(!courses.contains(course))
			{
				courses.add(course);
//				System.out.println("Student is enrolled for the course  "+ course + " Successfully!!");
				
			}
			else
			{
				System.err.println("Student has been aLready enrolled for the course "+ course);
			}
		}
		
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentId=" + studentId + ", courses=" + courses + "]";
	}
	
	public void printStudentInfo()
	{
		System.out.println("==========Student Detail============");
		System.out.println("Name: "+name);
		System.out.println("Age: "+age);
		System.out.println("StudenId: "+studentId);
		System.out.println("Courses Enrolled: "+courses);
			
	}
	
	public boolean validateAge(int age)
	{
		if(age>=19 && age<=35)
		{
			return true;
			
		}
		else
		{
			System.err.println("Incorrect Age value.It must be between 19 to 35");
			return false;
		}
	}
	
	public boolean validateName(String name)
	{
		String Nameregex= "[a-zA-Z\\s]+$";
		Pattern namePattern= Pattern.compile(Nameregex);
		Matcher namematch= namePattern.matcher(name);
		if(namematch.matches())
		{
			return true;
		}
		else
		{
			System.err.println("Invalid Student Name.Name should only contain alphaets and space");
			return false;
		}
		
	}
	
	public boolean validateStudentId(String studentId)
	{
		String studentIdregex="S-\\d+$";
		Pattern studentIdPattern= Pattern.compile(studentIdregex);
		Matcher StudentIdMatch= studentIdPattern.matcher(studentId);
		if(StudentIdMatch.matches())
		{
			return true;
		}
		else
		{
			System.err.println("Invalid StudentID.Please make sure it is correct!");
			return false;
		}
		
	}
	
	public boolean validateCourseName(String course)
	{
		if(course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("DSA") || course.equalsIgnoreCase("Python"))
		{
			return true;
		}
		else
		{
			System.err.println("Entered course is not available.Please check the available list [Java,DSA,Python]");
			return false;
		}
	}
	
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getStudentId() {
		return studentId;
	}

	public List<String> getCourses() {
		return courses;
	}
	 
	 
	 
	 
	 

}
