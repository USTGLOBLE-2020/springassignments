package com.springjdbc.apps.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springjdbc.apps.model.Employee;

import java.util.List;

@Repository
public class JdbcEmployeeRepositoryImpl implements EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Employee employee) {
        return jdbcTemplate.update("INSERT INTO Employee (name, email, dob) VALUES (?, ?, ?)", employee.getName(), employee.getEmail(), employee.getDob());
    }

    @Override
    public int update(Employee employee) {
        return jdbcTemplate.update("UPDATE Employee SET name = ?, email= ?, dob = ? WHERE id = ?", employee.getName(), employee.getEmail(), employee.getDob(), employee.getId());
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM Employee WHERE id = ?", id);
    }

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query("SELECT * FROM Employee", (rs, rowNum) ->
                new Employee(rs.getLong("id"), rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("dob")));
    }

    @Override
    public Employee findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Employee WHERE id = ?", new Object[]{id}, (rs, rowNum) ->
                new Employee(rs.getLong("id"), rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("dob")) );
    }
}
