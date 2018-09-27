package org.jasr.portfolio.controllers;

import java.util.Optional;

import org.jasr.portfolio.entities.Project;
import org.jasr.portfolio.entities.Tag;
import org.jasr.portfolio.entities.Type;
import org.jasr.portfolio.repositories.LinkRepository;
import org.jasr.portfolio.repositories.ProjectRepository;
import org.jasr.portfolio.repositories.TagRepository;
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
    private TagRepository     tagRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("types", typeRepository.findAll());
        model.addAttribute("tags", tagRepository.findAll());
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
    
    @PostMapping("/tag")
    public String upsertTag(@ModelAttribute Tag entity) {
        tagRepository.saveAndFlush(entity);
        return "redirect:/admin/index";
    }

    @GetMapping("/tag/delete/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable Long id) {
        tagRepository.deleteById(id);
        return new ResponseEntity<>(null,HttpStatus.OK);
    }
    
    @GetMapping("/tag/{id}")
    public ResponseEntity<Optional<Tag>> tag(@PathVariable Long id) {
        return new ResponseEntity<>(tagRepository.findById(id),HttpStatus.OK);
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
    
    @GetMapping("/project/{id}")
    public ResponseEntity<Optional<Project>> project(@PathVariable Long id) {
        return new ResponseEntity<>(projectRepository.findById(id),HttpStatus.OK);
    }
}
