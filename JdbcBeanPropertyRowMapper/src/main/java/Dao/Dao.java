package Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Dto.Student;

public interface Dao {
	
	public int insert(Student student);
	public void insertAll(ArrayList<Student> student);
	
	
	public int clearData();
	public Boolean deleteById(int i);
	public int  deleteByName(String name);
	
	public Student selectById(int i);
	public List<Student> selectAll();
	
	public int updateNameById(int i, String name);
	
	public Map<String, List<String> > studentCustomTable();

}
