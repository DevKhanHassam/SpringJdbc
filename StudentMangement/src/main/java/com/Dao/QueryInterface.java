package com.Dao;

import java.util.List;

import Dto.DtoStudent;
import Pojo.Student;

public interface QueryInterface {

	
	public List<Student> getAllData();
	
	public void addStudent(DtoStudent dtoStudent);
	public int deleteStudent(int x);
	public void updateStudent(int id, String name , String address);
	public Student getStudentById(int id);
}
