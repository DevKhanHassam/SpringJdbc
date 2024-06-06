package com.JdbcWithoutXml.com.JdcbcWithouXml;

import org.springframework.stereotype.Component;

@Component
public class Student_DTO {

		
		private int id;
		private String name;
		private String address;
		
		
		
		public Student_DTO() {
			super();
			
		}



		public Student_DTO(int id, String name, String address) {
			super();
			this.id = id;
			this.name = name;
			this.address = address;
		}



		public int getId() {
			return id;
		}



		public void setId(int id) {
			this.id = id;
		}



		public String getName() {
			return name;
		}



		public void setName(String name) {
			this.name = name;
		}



		public String getAddress() {
			return address;
		}



		public void setAddress(String address) {
			this.address = address;
		}



		@Override
		public String toString() {
			return "Student_DTO [id=" + id + ", name=" + name + ", address=" + address + "]";
		}
				
		
	}

