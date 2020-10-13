package com.Student.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.Student.bean.Student;



@Repository
public class StudentDaoImpl implements StudentDao{
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	class StudentRowMapper implements RowMapper<Student> {

		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

			Student student = new Student();

		//	student.setId(rs.getInt("id"));
			student.setName(rs.getString("name"));
			student.setEmailid(rs.getString("emailid"));
			student.setPhonenumber(rs.getString("phonenumber"));
			return student;
		}

	}

	

	@Override
	public List<Student> getAllStudentDetails() {
		String sql = "select * from student";

		List<Student> studentlist= jdbcTemplate.query(sql, new StudentRowMapper());
		
		try {
			jdbcTemplate.getDataSource().getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentlist;
	
			}



	@Override
	public String createStudent(Student student) {
		jdbcTemplate.update("insert into student(name,emailid,phonenumber) values(?,?,?)",student.getName(),student.getEmailid(),student.getPhonenumber());
		try {
			jdbcTemplate.getDataSource().getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "student created successfully";
	}



	@Override
	public List<Student> getStudentDetailsById(int id) {
		String sql = "select * from student where id=?";
		List<Student> studentlist= jdbcTemplate.query(sql,new PreparedStatementSetter() {
			   
			   public void setValues(PreparedStatement preparedStatement) throws SQLException {
			      preparedStatement.setInt(1, id);
			   }
			},
			new StudentRowMapper());
		try {
			jdbcTemplate.getDataSource().getConnection().close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return studentlist;
		
		}



	@Override
	public String updateStudent(int id, String email_address) {
		jdbcTemplate.update("update student set emailid=? where id=?",email_address,id);
		try {
			jdbcTemplate.getDataSource().getConnection().close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return "updated successfully";
	
		
	}



	@Override
	public String deleteEmployeebyId(int id) {
		
		jdbcTemplate.update("delete from student where id = ?",id);
		try {
			jdbcTemplate.getDataSource().getConnection().close();
		} catch (SQLException e) {
						e.printStackTrace();
		}
		return "deleted Successfully";
		
		
	}

}
