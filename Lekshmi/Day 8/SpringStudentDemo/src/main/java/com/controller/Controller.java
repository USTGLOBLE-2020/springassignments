package com.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Student;
import com.service.StudentSerivce;

/**
 * @author U65617
 *
 */

@RestController
@RequestMapping(value = ("/api"))
public class Controller {

	// inject dependecy service
	@Autowired
	private StudentSerivce studentSerivce;

	/**
	 * @return alt+shift+j for java doc
	 */
	@GetMapping("student-list")
	public List<Student> allStudents() {

		return studentSerivce.getStudents();

	}

	// api for list of student by id
	@GetMapping("student-list/{id}")
	public Student getStudentById(@PathVariable int id) throws SQLException {
		return studentSerivce.getStudents(id);
	}

	// api for create a new student details

	@PostMapping("student-create")
	public String createStudentDetails(@RequestBody Student student) throws SQLException {

		return studentSerivce.createStudentDetails(student);
	}

	// api for update student details

	/**
	 * @param id
	 * @param email_address
	 * @return
	 * @throws SQLException
	 */
	@PutMapping("student-udpate")
	public String updateStudentdetails(@PathVariable int id, @RequestParam String email_address) throws SQLException {

		return studentSerivce.updateStudentdetails(id, email_address);
	}

	// api for delete student by id
	@DeleteMapping("student-delete/{id}")
	public String deleteById(@PathVariable int id) throws SQLException {

		return studentSerivce.deleteById(id);

	}

}
