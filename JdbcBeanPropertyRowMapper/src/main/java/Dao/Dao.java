package Dao;

import java.util.ArrayList;

import Dto.Student;

public interface Dao {
	
	public int insert(Student student);
	public void insertAll(ArrayList<Student> student);
	
	
	public void clearData();
	public void deleteById(int i);
	
	public Student selectById(int i);
	public void selectAll();
	
	public void updateNameById(int i, String name);

}
