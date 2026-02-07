package com.kollu.springbootfiledata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kollu.springbootfiledata.model.Project;
import com.kollu.springbootfiledata.repository.TestRepository;

@RestController
@RequestMapping("/testapi")
public class TestController {
	
	@Autowired
	private TestRepository testRepository;

	// POST a new project
    @PostMapping("/savedata")
    public Project create(@RequestBody Project project) {
        return testRepository.save(project);
    }
    
    
 // GET all projects
    @GetMapping("/getdata")
    public List<Project> getAll() {
        return testRepository.findAll();
    }
    
	
}
