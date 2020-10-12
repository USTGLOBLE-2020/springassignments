package com.springjdbc.apps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springjdbc.apps.model.Employee;
import com.springjdbc.apps.repository.EmployeeRepository;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping("/viewlistofemployees")
    private List<Employee> viewAll(){
       
        return  repository.findAll();
    }
    @PostMapping("/insertemployee")
    private Long insert(@RequestBody Employee employee){
        repository.save(employee);
        return employee.getId();
    }
	
	   

    @PutMapping("/update")
    private int update(@RequestBody Employee employee){
      return repository.update(employee);
        
    }

    @GetMapping("/delete")
    private int delete(@RequestParam("id") Long id){
       
        return  repository.deleteById(id);
    }
}
