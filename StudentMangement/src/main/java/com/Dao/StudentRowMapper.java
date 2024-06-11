package com.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import Pojo.Student;

@Component
public class StudentRowMapper implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Student student= new Student();
		student.setRollNo(rs.getInt(1));
		student.setStudentName(rs.getString(2));
		student.setStudentAddress(rs.getString(3));
		
		return student;
	}

}
