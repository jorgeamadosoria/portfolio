package org.jasr.portfolio.controllers;

import org.jasr.portfolio.entities.Type;
import org.jasr.portfolio.repositories.LinkRepository;
import org.jasr.portfolio.repositories.ProjectRepository;
import org.jasr.portfolio.repositories.TagRepository;
import org.jasr.portfolio.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {
	@Autowired
	private TypeRepository typeRepository;
	@Autowired
	private LinkRepository linkRepository;
	@Autowired
	private TagRepository tagRepository;
	@Autowired
	private ProjectRepository projectRepository;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("types", typeRepository.findAll());
        model.addAttribute("tags", tagRepository.findAll());
        model.addAttribute("projects", projectRepository.findAll());
        return "index";
    }

    @PostMapping("/type")
    public String type(@ModelAttribute  Type type) {
    	
    	typeRepository.saveAndFlush(type);
        return "redirect:index";
    }
}