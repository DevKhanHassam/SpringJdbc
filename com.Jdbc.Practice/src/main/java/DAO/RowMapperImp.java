package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Jdbc.com.Jdbc.Practice.Student_DTO;

public class RowMapperImp implements RowMapper<Student_DTO> {

	@Override
	public Student_DTO mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		Student_DTO obj = new Student_DTO();
		
		obj.setId(rs.getInt(1));
		obj.setName(rs.getNString(2));
		obj.setAddress(rs.getNString(3));
		
		return obj;
	}

}
