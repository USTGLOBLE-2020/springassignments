package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.Employee;

@Repository
public class EmpDaoImp implements EmpDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	class EmployeeRowMapper implements RowMapper<Employee> {

		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

			Employee employee = new Employee();

			// employee.setId(rs.getRowId("id"));
			employee.setFirst_name(rs.getString("first_name"));
			employee.setLast_name(rs.getString("last_name"));
			employee.setEmail_address(rs.getString("email_address"));
			return employee;
		}

	}

	// get the list of emloyess // go your implement for jdbc or spring jpa in this
	// class
	public List<Employee> getEmployees() {

		String sql = "select * from employees";

		return jdbcTemplate.query(sql, new EmployeeRowMapper());

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String createEmployeeDetails(Employee employee) throws SQLException {
		// TODO Auto-generated method stub
		String insertQuery = "insert into employees(id,first_name,last_name,email_address) values(?,?,?,?)";
		jdbcTemplate.update(insertQuery, employee.getId(),employee.getFirst_name(),employee.getLast_name(),employee.getEmail_address());
		jdbcTemplate.getDataSource().getConnection().close();
		return "new employee successfully created";
	}

	@Override
	public String updateEmployeedetails(int id, String email_address) throws SQLException {
		// TODO Auto-generated method stub
		String updateQuery = "update employees set email_address=? where id=?";
		jdbcTemplate.update(updateQuery,id,email_address);
		jdbcTemplate.getDataSource().getConnection().close();
		return "Successfully updated!";
	}

	@Override
	public String deleteById(int id) throws SQLException {
		// TODO Auto-generated method stub
		String deleteQuery="delete from employees where id = ?";
		jdbcTemplate.update(deleteQuery,id);
		jdbcTemplate.getDataSource().getConnection().close();
		return "Successsfully Deleted";
	}

	
	
	
	
	
	
}
