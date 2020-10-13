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

		    employee.setId(rs.getInt("id"));
			employee.setFirst_name(rs.getString("first_name"));
			employee.setLast_name(rs.getString("last_name"));
			employee.setEmail_address(rs.getString("email_address"));
			return employee;
		}

	}

	// get the list of emloyess // go your implement for jdbc or spring jpa in this
	// class
	
	public List<Employee> getAllEmployee() {

		String sql = "select * from employees ";

		return jdbcTemplate.query(sql, new EmployeeRowMapper());

	}
	@Override
	public List<Employee> getEmployeesById(int id) {

		String sqlSelect = "select * from employees where id=?'";

		 return jdbcTemplate.query(sqlSelect, new EmployeeRowMapper());

	}
	@Override
	public String createEmployeeDetails(Employee employee){

		String sqlInsert = "insert into employees (id,first_name,last_name,email_address) values(?,?,?,?)";

		 jdbcTemplate.update(sqlInsert, new EmployeeRowMapper());
		
	return("Inserted successfully");
	}
	@Override
	public String updateEmployeeById(int id,String first_name,String last_name,String email_address){

		String sqlUpdate = "update employees set(first_name=?,last_name=?,email_address=?) where id=?";

		 jdbcTemplate.update(sqlUpdate, new EmployeeRowMapper());
		
		 return ("updated successfully");
	}
	@Override
	public String deleteByEmployeeId(int id){

		String sqlDelete = "delete * from employees where id=?";

		 jdbcTemplate.update(sqlDelete, new EmployeeRowMapper());
		
		 return ("Deleted successfully")
	
	}
}
