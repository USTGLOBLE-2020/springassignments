package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class SpringBootJdbcController {
	@Autowired
	JdbcTemplate jdbc;
	
	@RequestMapping("/displayMessage")
	public String displayMessage() {
		return "Hello World";
	}
	
	@RequestMapping("/insertBook")
	public String insertOperation() {
		jdbc.execute("insert into book(id,author,isbn,name,org) values(190,'Vijay',800,'Bandi','ust')");
		return "Data inserted";
	}
}
