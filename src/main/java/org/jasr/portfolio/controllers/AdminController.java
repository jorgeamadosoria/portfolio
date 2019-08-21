package org.jasr.portfolio.controllers;

import java.util.Optional;

import org.jasr.portfolio.entities.Project;
import org.jasr.portfolio.entities.Status;
import org.jasr.portfolio.entities.Tech;
import org.jasr.portfolio.entities.Type;
import org.jasr.portfolio.repositories.ProjectRepository;
import org.jasr.portfolio.repositories.TechRepository;
import org.jasr.portfolio.repositories.TypeRepository;
import org.jasr.portfolio.services.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("admin")
public class AdminController {
	@Autowired
	private TypeRepository typeRepository;
	@Autowired
	private TechRepository techRepository;
	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserService usersService;

	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("types", typeRepository.findAll());
		model.addAttribute("tech", techRepository.findAll(Sort.by("name")));
		model.addAttribute("statuses", Status.values());
		model.addAttribute("projects", projectRepository.findAll());
		return "admin/index";
	}

	@PostMapping("/type")
	public String upsertType(Model model, @ModelAttribute Type entity, @RequestParam String tab) {
		model.addAttribute("tab",tab);
		typeRepository.saveAndFlush(entity);
		return index(model);
	}

	@PostMapping("/password")
	public String changePassword(Model model, @RequestParam String tab,@RequestParam String cpassword, @RequestParam String npassword, @RequestParam String rpassword) {
		model.addAttribute("tab",tab);
		if (!StringUtils.isEmpty(cpassword) && !StringUtils.isEmpty(npassword) && npassword.equals(rpassword) && passwordEncoder.matches(cpassword, usersService.loadUserByUsername("admin").getPassword()))
			usersService.changePassword(cpassword, npassword);
		return index(model);
	}

	@GetMapping("/type/delete/{id}")
	public ResponseEntity<Void> deleteType(@PathVariable Long id) {
		typeRepository.deleteById(id);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@GetMapping("/type/{id}")
	public ResponseEntity<Optional<Type>> type(@PathVariable Long id) {
		return new ResponseEntity<>(typeRepository.findById(id), HttpStatus.OK);
	}

	@PostMapping("/tech")
	public String upsertTech(Model model, @RequestParam String tab,@ModelAttribute Tech entity) {
		model.addAttribute("tab",tab);
		techRepository.saveAndFlush(entity);
		return index(model);
	}

	@GetMapping("/tech/delete/{id}")
	public ResponseEntity<Void> deleteTech(@PathVariable Long id) {
		techRepository.deleteById(id);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@GetMapping("/tech/{id}")
	public ResponseEntity<Optional<Tech>> tech(@PathVariable Long id) {
		return new ResponseEntity<>(techRepository.findById(id), HttpStatus.OK);
	}


	@GetMapping("/project/{id}")
	public ResponseEntity<Optional<Project>> project(@PathVariable Long id) {
		return new ResponseEntity<>(projectRepository.findById(id), HttpStatus.OK);
	}

	@PostMapping("/project")
	public String upsertProject(Model model, @RequestParam String tab,@ModelAttribute Project entity) {
		model.addAttribute("tab",tab);
		projectRepository.saveAndFlush(entity);
		return index(model);
	}

	@GetMapping("/project/delete/{id}")
	public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
		projectRepository.deleteById(id);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

}
