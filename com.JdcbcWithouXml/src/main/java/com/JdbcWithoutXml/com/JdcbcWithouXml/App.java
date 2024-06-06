package com.JdbcWithoutXml.com.JdcbcWithouXml;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import DAO.Query;

public class App {
	public static void main(String[] args) {
		
		
		
		ApplicationContext context = new  AnnotationConfigApplicationContext(Configure.class);
		
//		Student_DTO studentObj = context.getBean(Student_DTO.class);
////		studentObj.setId(234);
////		studentObj.setName("xyz");
////		studentObj.setAddress("check123");
		
		
		
		Query queryObj = context.getBean(Query.class);
		 
		List<Student_DTO> selectAllData = queryObj.selectAllData();
		
		for(Student_DTO x: selectAllData)
		{
			System.out.println(x);
		}
	
		

	}
}
