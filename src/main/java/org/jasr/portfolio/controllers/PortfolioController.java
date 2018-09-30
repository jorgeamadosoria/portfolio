package org.jasr.portfolio.controllers;

import org.jasr.portfolio.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PortfolioController {
	@Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/index")
    public String greeting(Model model) {
    	model.addAttribute("projects", projectRepository.findAll());
        return "index";
    }

}