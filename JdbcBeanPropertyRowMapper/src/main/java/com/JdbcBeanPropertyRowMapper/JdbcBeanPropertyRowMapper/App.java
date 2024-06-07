package com.JdbcBeanPropertyRowMapper.JdbcBeanPropertyRowMapper;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Dao.DaoStudent;
import Dto.Student;

public class App 
{
    public static void main( String[] args )
    {
       
    	ApplicationContext context = new AnnotationConfigApplicationContext(Configure.class);
    	
    	
    	DaoStudent dao = context.getBean("daoStudent", DaoStudent.class);
    	
    	
    	dao.clearData();
    	
    	
    	Student student1 = new Student();
    	
    	student1.setRollNo(1);
    	student1.setStudentName("Hassam");
    	student1.setStudentAddress("Germany");
    	
    	
    	Student student2 = new Student();
    	
    	student2.setRollNo(2);
    	student2.setStudentName("Ali");
    	student2.setStudentAddress("Germany");
    	
    	
    	ArrayList<Student> studentList = new ArrayList<>();
    	
    	studentList.add(student1);
    	studentList.add(student2);
    	
    	
    	
    	dao.insertAll(studentList);
    	
    	
    	
    	Student student3 = new Student();
    	student3.setRollNo(10);
    	student3.setStudentAddress("Karachi");
    	student3.setStudentName("Faraz");
    	
    	dao.insert(student3);
  
    	dao.selectAll();
    	System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    	
    	dao.studentCustomTable();

    	
//    	dao.selectById(5);
//    	dao.selectAll();
//    	dao.updateNameById(5, "Sheishe");
//    	dao.deleteById(3);
//    	dao.deleteByName("Hassam");

 
    	
    	
   
    	
    	
    	
    	
    	((AnnotationConfigApplicationContext) context).close();
    	
    	
    	
    	
    }
}
