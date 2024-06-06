package com.JdbcWithoutXml.com.JdcbcWithouXml;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = {"com.JdbcWithoutXml.com.JdcbcWithouXml", "DAO"})
public class Configure {
	
	
	
	
	@Bean
	public DriverManagerDataSource setUpDriver()
	{
		DriverManagerDataSource DriverObj = new DriverManagerDataSource();
		DriverObj.setDriverClassName("com.mysql.jdbc.Driver");
		DriverObj.setUrl("jdbc:mysql://localhost:3306/newspringjdbc?autoReconnect=true&useSSL=false");
		DriverObj.setUsername("root");
		DriverObj.setPassword("admin");
		
		return DriverObj;
		
	}
	

	
	
	@Bean
	public JdbcTemplate jdbcTemplate()
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(setUpDriver());
		return jdbcTemplate;
	}
	
	
	
	

}
