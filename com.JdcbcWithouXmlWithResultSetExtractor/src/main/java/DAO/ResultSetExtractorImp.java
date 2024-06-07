package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.JdbcWithoutXml.com.JdcbcWithouXml.Student_DTO;


@Component
public class ResultSetExtractorImp implements ResultSetExtractor<List<Student_DTO>> {

	@Override
	public List<Student_DTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		
		List<Student_DTO> studentList = new ArrayList<>();
		
		while(rs.next())
		{
			Student_DTO obj = new Student_DTO();
			
			obj.setId(rs.getInt("id"));
			obj.setName(rs.getString("name"));
			obj.setAddress(rs.getString("city"));
			
			studentList.add(obj);
		
		}
		
		System.out.println("Inside row Mapper");
		return studentList;
	}

}
