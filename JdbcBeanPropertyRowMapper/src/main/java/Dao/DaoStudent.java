package Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Dto.Student;

@Repository
public class DaoStudent extends Thread implements Dao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	MycustomResultSetExtractor resultSetExtractor;

	public int insert(Student obj)

	{

		String sql = "insert into studenttable (RollNo, StudentName, StudentAddress) values (?,?,?)";

		Object[] student = { obj.getRollNo(), obj.getStudentName(), obj.getStudentAddress() };

		int insert = jdbcTemplate.update(sql, student);

		System.out.println(insert + " row inserted");

		return insert;
	}

	public void insertAll(ArrayList<Student> student) {

		String sql = "Insert into studenttable (RollNo, StudentName, StudentAddress) values (?,?,?)";

		ArrayList<Object[]> args = new ArrayList<>();

		for (Student x : student) {
			Object[] studentdata = { x.getRollNo(), x.getStudentName(), x.getStudentAddress() };
			args.add(studentdata);
		}

		 jdbcTemplate.batchUpdate(sql, args);

		System.out.println("BatchUpdate successfully done");
	}

	public int clearData() {

		String sql = "TRUNCATE TABLE studenttable";
		int update = jdbcTemplate.update(sql);
		System.out.println(update+" row(s) has been deleted");
		return update;

	}

	public Boolean deleteById(int i) {

		String sql = "delete from studenttable where RollNo=?";
		int del = jdbcTemplate.update(sql, i);

		if (del == 1) {
			System.out.println(del + "row deleted");
			selectAll();
			return true;
		} else {
			System.out.println("Incorrect ID");
			return del == 1;
		}

	}

	public int deleteByName(String name)
	{
		try {
			String sql="delete from studenttable where StudentName=?";
			int update = jdbcTemplate.update(sql,name);
			if(update==0)
			{
				System.out.println("Name not match with data");
				return 0;
			}
			System.out.println(update+" rows deleted");
			selectAll();
			return update;
		} catch (Exception e) {
			return 0;
		}
	}
//	BeanPropertyRowMapper  if table column and Dto property name change then use Aliases=(select fname as first_name from customer)
	public Student selectById(int i) {

		try {
			String sql = "Select * from studenttable where RollNO=?";
			Student studentData = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Student>(Student.class),
					i);

			System.out.println(studentData);
			return studentData;
		}

		catch (Exception e) {
			System.out.println("Invalid RollNo to selectById");
			return null;
		}
	}

//	BeanPropertyRowMapper if table column and Dto property name change then use Aliases=(select fname as first_name from customer)
	public List<Student> selectAll() {

		try {

			String sql = "Select * from studenttable";
			List<Student> studentData = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class));

			for (Student x : studentData) {
				System.out.println(x);
			}
			
			return studentData;

		} catch (Exception e) {
			
			System.out.println(e);
			return new  ArrayList<Student>();

		}

	}

	public int updateNameById(int i, String name) {

		try {

			if (selectById(i) == null) {
				System.out.println("Invalid RollNo to UpdateById");
				return 0;
			} else {
				System.out.println("Old Record");
				selectById(i);
				String sql = "update studenttable set StudentName= ? where RollNo = ?";
				int update = jdbcTemplate.update(sql, name, i);
				System.out.println(update + " Name updated");

				System.out.println("New Record");
				selectById(i);
				return update;
			}
		}

		catch (Exception e) {
			System.out.println(e);
			return 0;
		}

	}

	
//	Custom ResultSetExtractor
	@Override
	public Map<String, List<String>> studentCustomTable() {
		
		String sql="select * from studenttable";
		Map<String, List<String>> studentMap = jdbcTemplate.query(sql, resultSetExtractor );
		
		for(Map.Entry<String, List<String>> x: studentMap.entrySet())
		{
			System.out.println(x.getKey()+" list= "+x.getValue());
		}
		
		
		return studentMap;
	}

}
