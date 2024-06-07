package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;


@Component
public class MycustomResultSetExtractor implements ResultSetExtractor<Map<String, List<String>>> {

	public Map<String, List<String>> extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		Map<String, List<String>> studentMap = new HashMap<>();
		
		
		
		
		while(rs.next())
		{
			List<String> studentName = new ArrayList<>();
			
			studentName.add(rs.getString(2));  //StudentName
			String mykey=rs.getString(3);     //StudentAddress
			
			if(studentMap.containsKey(mykey))
				{
					List<String> oldlist = studentMap.get(mykey);
					for(String x: oldlist)
						{
						studentName.add(x);
						}
				
					studentMap.put(mykey, studentName);
				}
			
			studentMap.put(mykey, studentName);
		}
		
		return studentMap;
	}

}
