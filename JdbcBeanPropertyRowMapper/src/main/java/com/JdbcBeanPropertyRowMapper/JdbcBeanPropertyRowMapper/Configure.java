package com.JdbcBeanPropertyRowMapper.JdbcBeanPropertyRowMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"Dao","Dto"})
public class Configure {
	
	
	
	
	@Bean
	public DriverManagerDataSource  setUpDriver()
	{
		DriverManagerDataSource obj = new DriverManagerDataSource();
		
		obj.setDriverClassName("com.mysql.jdbc.Driver");
		obj.setUrl("jdbc:mysql://localhost:3306/school?autoReconnect=true&useSSL=false");
		obj.setUsername("root");
		obj.setPassword("admin");
		
		return obj;
		
	}
	
	
	@Bean
	public JdbcTemplate template()
	{
		JdbcTemplate obj = new JdbcTemplate();
		obj.setDataSource(setUpDriver());
		return obj;
	}

}
