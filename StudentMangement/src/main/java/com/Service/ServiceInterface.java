package com.Service;

import java.util.List;

import Dto.DtoStudent;
import Pojo.Student;

public interface ServiceInterface {
	
	
public List<Student> getAllData();
	
	public void addStudent(DtoStudent dtoStudent);
	public String deleteStudent(int x);

}
