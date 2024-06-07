package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.JdbcWithoutXml.com.JdcbcWithouXml.Student_DTO;


@Component
public class RowMapperImp implements RowMapper<Student_DTO>

{
	
	

	public Student_DTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Student_DTO student_DTO = new  Student_DTO();
		
//		student_DTO.setId(rs.getInt(1));  we can give both column no or name
		student_DTO.setId(rs.getInt("id"));
		
//		student_DTO.setName(rs.getString(2));we can give both column no or name
		student_DTO.setName(rs.getString("name"));
		
//		student_DTO.setAddress(rs.getString(3));we can give both column no or name
		student_DTO.setAddress(rs.getString("city"));
		return student_DTO;
	}

}
