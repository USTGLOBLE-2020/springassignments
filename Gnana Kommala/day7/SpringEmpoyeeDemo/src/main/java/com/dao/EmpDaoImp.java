package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
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
			employee.setEmail_address(rs.getString("address"));
			return employee;
		}

	}

	
	public List<Employee> getEmployees() {

		String sql = "select * from employee";

		List<Employee> employeelist= jdbcTemplate.query(sql, new EmployeeRowMapper());
		
		try {
			jdbcTemplate.getDataSource().getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeelist;
	}

	public List<Employee> getEmplyeeDetailsById(int id) {
		String sql = "select * from employee where id=?";

		List<Employee> employeelist= jdbcTemplate.query(sql,new PreparedStatementSetter() {
			   
			   public void setValues(PreparedStatement preparedStatement) throws SQLException {
			      preparedStatement.setInt(1, id);
			   }
			},
			new EmployeeRowMapper());
		try {
			jdbcTemplate.getDataSource().getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeelist;
		
	}


	@Override
	public String createEmployee(Employee employee) {
		
		jdbcTemplate.update("insert into employee(first_name,last_name,address,id) values(?,?,?,?)", employee.getFirst_name(),employee.getLast_name(),employee.getEmail_address(),employee.getId());
		try {
			jdbcTemplate.getDataSource().getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "added successfully";
	}


	@Override
	public String updateEmployee(int id, String email_address) {
		jdbcTemplate.update("update employee set address=? where id=?",email_address,id);
		try {
			jdbcTemplate.getDataSource().getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "updated successfully";
	}


	@Override
	public String deleteEmployeebyId(int id) {
		jdbcTemplate.update("delete from employee where id = ?",id);
		try {
			jdbcTemplate.getDataSource().getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "deleted Successfully";
	}

	@Override
	public List<Employee> getEmplyeeDetailsId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}


