package org.jasr.portfolio.controllers;

import java.util.Optional;

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
    public String upsertType(@ModelAttribute Type type) {
        typeRepository.saveAndFlush(type);
        return "redirect:/admin/index";
    }

    @GetMapping("/type/delete/{id}")
    public ResponseEntity<Void> deleteType(@PathVariable Long id) {
        typeRepository.delete(new Type(id));
        return new ResponseEntity<>(null,HttpStatus.OK);
    }
    
    @GetMapping("/type/{id}")
    public ResponseEntity<Optional<Type>> type(@PathVariable Long id) {
        return new ResponseEntity<Optional<Type>>(typeRepository.findById(id),HttpStatus.OK);
    }
}
