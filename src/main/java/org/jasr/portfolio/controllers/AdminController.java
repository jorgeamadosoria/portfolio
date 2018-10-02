package org.jasr.portfolio.controllers;

import java.util.Optional;

import org.jasr.portfolio.entities.Project;
import org.jasr.portfolio.entities.Status;
import org.jasr.portfolio.entities.Tech;
import org.jasr.portfolio.entities.Type;
import org.jasr.portfolio.repositories.LinkRepository;
import org.jasr.portfolio.repositories.ProjectRepository;
import org.jasr.portfolio.repositories.TechRepository;
import org.jasr.portfolio.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private TypeRepository    typeRepository;
    @Autowired	
    private LinkRepository    linkRepository;
    @Autowired
    private TechRepository     techRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("types", typeRepository.findAll());
        model.addAttribute("tech", techRepository.findAll());
        model.addAttribute("statuses", Status.values());
        model.addAttribute("projects", projectRepository.findAll());
        return "/admin/index";
    }

    @PostMapping("/type")
    public String upsertType(@ModelAttribute Type entity) {
        typeRepository.saveAndFlush(entity);
        return "redirect:/admin/index";
    }

    @GetMapping("/type/delete/{id}")
    public ResponseEntity<Void> deleteType(@PathVariable Long id) {
        typeRepository.deleteById(id);
        return new ResponseEntity<>(null,HttpStatus.OK);
    }
    
    @GetMapping("/type/{id}")
    public ResponseEntity<Optional<Type>> type(@PathVariable Long id) {
        return new ResponseEntity<>(typeRepository.findById(id),HttpStatus.OK);
    }
    
    @PostMapping("/tech")
    public String upsertTech(@ModelAttribute Tech entity) {
        techRepository.saveAndFlush(entity);
        return "redirect:/admin/index";
    }

    @GetMapping("/tech/delete/{id}")
    public ResponseEntity<Void> deleteTech(@PathVariable Long id) {
        techRepository.deleteById(id);
        return new ResponseEntity<>(null,HttpStatus.OK);
    }
    
    @GetMapping("/tech/{id}")
    public ResponseEntity<Optional<Tech>> tech(@PathVariable Long id) {
        return new ResponseEntity<>(techRepository.findById(id),HttpStatus.OK);
    }
    
    @PostMapping("/project")
    public String upsertProject(@ModelAttribute Project entity) {
        projectRepository.saveAndFlush(entity);
        return "redirect:/admin/index";
    }

    @GetMapping("/project/delete/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectRepository.deleteById(id);
        return new ResponseEntity<>(null,HttpStatus.OK);
    }
    

}
