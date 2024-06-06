package DAO;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.Jdbc.com.Jdbc.Practice.Student_DTO;

public class Query {

	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(Student_DTO student) {

		String query = "insert into student(id, name,city) values(?,?,?)";

		int update = jdbcTemplate.update(query, student.getId(), student.getName(), student.getAddress());
		System.out.println("Insert sucessfull " + update);

		return update;

	}

	public int update(Student_DTO student) {

		String query = "update student set name=?, city=? where id=?";

		int update = jdbcTemplate.update(query, student.getName(), student.getAddress(), student.getId());
		System.out.println("update sucessfull " + update);
		return update;

	}

	public int delete(Student_DTO student) {

		String query = "DELETE FROM student WHERE id=?";

		int update = jdbcTemplate.update(query, student.getId());
		System.out.println("Delete sucessfull " + update);
		return update;

	}

	public Student_DTO selectById(Student_DTO student) {

		String query = "select * from student where id=?";

		RowMapper<Student_DTO> obj = new RowMapperImp();

		Student_DTO studentObj = jdbcTemplate.queryForObject(query, obj, student.getId());

		return studentObj;
	}
	
	
	
	public List<Student_DTO> selectAllData()
	{
		
		String query="select * from student";
		RowMapper<Student_DTO> obj = new RowMapperImp();
		 List<Student_DTO> allObjects = jdbcTemplate.query(query,obj);
		
		return allObjects;
		
	}

}
