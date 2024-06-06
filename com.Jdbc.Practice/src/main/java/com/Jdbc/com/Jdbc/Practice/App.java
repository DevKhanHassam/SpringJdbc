package com.Jdbc.com.Jdbc.Practice;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import DAO.Query;

public class App 
{
    public static void main( String[] args )
    {
        
        
       ApplicationContext context = new ClassPathXmlApplicationContext("com/Jdbc/com/Jdbc/Practice/configure.xml");      
       Query bean = context.getBean("myQuery", Query.class);
        
       
       Student_DTO student = new Student_DTO();
       
      
     
       List<Student_DTO> selectAllData = bean.selectAllData();
       
       
       
       for(Student_DTO x: selectAllData)
       {
    	   System.out.println(x);
       }
        
      
    
       
//       ((ClassPathXmlApplicationContext)context).close();
        
    }
}
