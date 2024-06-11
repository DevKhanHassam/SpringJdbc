package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dao.QueryImp;

import Dto.DtoStudent;
import Pojo.Student;

@Service
public class ServiceImp implements ServiceInterface {

	@Autowired
	QueryImp queryImp;
	
	@Override
	public List<Student> getAllData() {
		
		return queryImp.getAllData();
	}

	@Override
	public void addStudent(DtoStudent dtoStudent) {
		queryImp.addStudent(dtoStudent);

	}

	@Override
	public String deleteStudent(int x) {
		
		
		int noOfDelete = queryImp.deleteStudent(x);
		if(noOfDelete==0)
		{
			return "invalid";
		}
		
		return "redirect:/";
	}

	@Override
	public Student getStudentById(int id) {
		
		
		
		return queryImp.getStudentById(id);
	}

	
	public void updateStudent(int id, String name, String address) {
		
		queryImp.updateStudent(id, name, address);
		
	}
	


	
	
	

}
