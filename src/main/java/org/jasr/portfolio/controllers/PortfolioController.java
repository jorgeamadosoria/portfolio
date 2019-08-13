package org.jasr.portfolio.controllers;

import java.util.Optional;

import org.jasr.portfolio.entities.Project;
import org.jasr.portfolio.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PortfolioController {
	@Autowired
    private ProjectRepository projectRepository;

	
    @GetMapping(value= {"/","/index"})
    public String index(Model model) {
    	model.addAttribute("projects", projectRepository.findAll());
        return "index";
    }
    
    @GetMapping("/about")
    public String about(Model model) {
        return "about";
    }
    
    @GetMapping("/project/{id}")
    public ResponseEntity<Optional<Project>> project(@PathVariable Long id) {
        return new ResponseEntity<>(projectRepository.findById(id),HttpStatus.OK);
    }
}