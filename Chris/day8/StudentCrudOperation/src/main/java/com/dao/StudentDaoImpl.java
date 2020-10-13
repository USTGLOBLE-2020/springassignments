package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bean.Student;


@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	class StudentRowMapper implements RowMapper<Student> {

		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

			Student student = new Student();

			student.setRollno(rs.getInt("rollno"));
			student.setName(rs.getString("name"));
			student.setEmail(rs.getString("email"));
			student.setPhone(rs.getString("phone"));
			return student;
		}

	}


	// get the list of Student 
	
	@Override
	public List<Student> getAllStudents() {
		String sql = "select * from students ";

		return jdbcTemplate.query(sql,new StudentRowMapper());
	}
	@Override
	public List<Student> getStudentById(int rollno) {
		String sqlSelect = "select * from students where rollno=?'";

		 return jdbcTemplate.query(sqlSelect, new StudentRowMapper());
	}
	@Override
	public String createStudentDetails(Student student) {
		String sqlInsert = "insert into students (rollno,name,email,phone) values(?,?,?,?)";

		 jdbcTemplate.update(sqlInsert, new StudentRowMapper());
			return("Inserted successfully");
	}
	@Override
	public String updateStudentById(int rollno, String name, String email, String phone) {
		String sqlUpdate = "update students set(name=?,email=?,phone=?) where rollno=?";

		 jdbcTemplate.update(sqlUpdate, new StudentRowMapper());
		 return ("updated successfully");
	@Override
	public String deleteByStudentId(int rollno) {

		String sqlDelete = "delete * from students where rollno=?";

		 jdbcTemplate.update(sqlDelete, new StudentRowMapper());
		
		 return ("Deleted successfully");
	}
}
