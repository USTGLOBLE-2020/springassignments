package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.Student;

@Repository
public class StudentDaoImp implements StudentDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	class StudentRowMapper implements RowMapper<Student> {

		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

			Student student = new Student();

			// employee.setId(rs.getRowId("id"));
			student.setFirst_name(rs.getString("first_name"));
			student.setLast_name(rs.getString("last_name"));
			student.setEmail_address(rs.getString("email_address"));
			student.setAge(rs.getString("age"));
			student.setAddress(rs.getString("address"));
			student.setMobile_number(rs.getLong("mobile_number"));
			return student;
		}

	}

	// get the list of emloyess // go your implement for jdbc or spring jpa in this
	// class
	public List<Student> getStudents() {

		String sql = "select * from student";

		return jdbcTemplate.query(sql, new StudentRowMapper());

	}

	@Override
	public Student getStudents(int id) throws SQLException {

		String listbyidQuery = "select * from student where id=?";

		return jdbcTemplate.queryForObject(listbyidQuery, new Object[] { id }, new StudentRowMapper());

	}

// create a new  student details
	@Override
	public String createStudentDetails(Student student) throws SQLException {
				String insertQuery = "insert into student(id,first_name,last_name,email_address,age,address,mobile_number) values(?,?,?,?,?,?,?)";
		jdbcTemplate.update(insertQuery, student.getId(), student.getFirst_name(), student.getLast_name(),
				student.getEmail_address(), student.getAge(), student.getAddress(), student.getMobile_number());
		jdbcTemplate.getDataSource().getConnection().close();
		return "successfully created";
	}

	// edit/modify/update student
	@Override
	public String updateStudentdetails(int id, String email_address) throws SQLException {
		String updateQuery = "update student set email_address=? where id=?";
		jdbcTemplate.update(updateQuery, id, email_address);
		jdbcTemplate.getDataSource().getConnection().close();

		return "Successfully Updated";
	}

	// delete student by id
	@Override
	public String deleteById(int id) throws SQLException {
		String deleteQuery = "delete from student where id = ?";
		jdbcTemplate.update(deleteQuery, id);
		jdbcTemplate.getDataSource().getConnection().close();
		return "Successsfully Deleted";
	}

}
