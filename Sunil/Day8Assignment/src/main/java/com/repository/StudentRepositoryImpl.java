package com.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.model.Student;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	class StudentRowMapper implements RowMapper<Student> {

		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

			Student student = new Student();

			student.setId(rs.getInt("id"));
			student.setName(rs.getString("name"));
			student.setEmailAddress(rs.getString("emailAddress"));
			student.setPhoneNumber(rs.getString("phoneNumber"));
			return student;
		}

	}

	@Override
	public List<Student> getAllStudents() {

		String sql = "select * from student";

		return jdbcTemplate.query(sql, new StudentRowMapper());

	}
	
	@Override
	public List<Student> getStudentByID(int id) {
		String sql = "select * from student where id=?";

		List<Student> student= jdbcTemplate.query(sql,new PreparedStatementSetter() {
			   
			   public void setValues(PreparedStatement preparedStatement) throws SQLException {
			      preparedStatement.setInt(1, id);
			   }
			},
			new StudentRowMapper());
		try {
			jdbcTemplate.getDataSource().getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;

	}
	

	@Override
	public String createStudent(Student student) {
		
		jdbcTemplate.update("insert into student(id,name,emailAddress,phoneNumber) values(?,?,?,?)",student.getId(), student.getName(),student.getEmailAddress(),student.getPhoneNumber());
		try {
			jdbcTemplate.getDataSource().getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Created successfully";
	}

	@Override
	public String updateStudent(int id, String emailAddress,String phoneNumber) {
		jdbcTemplate.update("update student set emailAddress=? where id=?",emailAddress,id);
		try {
			jdbcTemplate.getDataSource().getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "updated successfully";
	}


	@Override
	public String deleteStudentbyId(int id) {
		jdbcTemplate.update("delete from student where id = ?",id);
		try {
			jdbcTemplate.getDataSource().getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "deleted Successfully";
	}
	
	@Override
	public String deleteStudents() {
		jdbcTemplate.update("delete from student");
		try {
			jdbcTemplate.getDataSource().getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "deleted Successfully";
	}

}
