package com.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Dto.DtoStudent;
import Pojo.Student;

@Repository
@Transactional
public class QueryImp  implements QueryInterface{

	@Autowired
	JdbcTemplate jdbctemplate;
	
	public List<Student> getAllData()
	{
		try {
			String sql="Select * from studenttable";
			List<Student> studentList= jdbctemplate.query(sql,new BeanPropertyRowMapper<Student>(Student.class));
			return studentList;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	
	public void addStudent(DtoStudent dtoStudent) {
		
		String sql="insert into studenttable (RollNo, StudentName, StudentAddress) values (?,?,?)";
		Object[] args= {dtoStudent.getId(), dtoStudent.getName(),dtoStudent.getAddress()};
		
		jdbctemplate.update(sql, args);
		
	}


	
	public int deleteStudent(int x) {

			String sql="Delete from studenttable where RollNo=?";
			int update = jdbctemplate.update(sql,x);
			
			return update;
	}
	
}
