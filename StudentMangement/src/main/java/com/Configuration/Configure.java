package com.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com")
public class Configure implements  WebMvcConfigurer {
	@Bean
	public InternalResourceViewResolver setDispatcher() {
		InternalResourceViewResolver obj = new InternalResourceViewResolver();
		obj.setPrefix("/WEB-INF/Views/");
		obj.setSuffix(".jsp");
		return obj;
	}

	@Bean
	public DriverManagerDataSource setUpDriver() {
		DriverManagerDataSource obj = new DriverManagerDataSource();

		obj.setDriverClassName("com.mysql.jdbc.Driver");
		obj.setUrl("jdbc:mysql://localhost:3306/school?autoReconnect=true&useSSL=false");
		obj.setUsername("root");
		obj.setPassword("admin");

		return obj;

	}

	@Bean
	public JdbcTemplate template() {
		JdbcTemplate obj = new JdbcTemplate();
		obj.setDataSource(setUpDriver());
		return obj;
	}

	public void addResourceHandlers(ResourceHandlerRegistry registry) 
	{
		 registry.addResourceHandler("/static/**")
         .addResourceLocations("classpath:/static/");
		}
	
	
	
}
