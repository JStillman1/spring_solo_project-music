package com.example.spring_solo_project.controller;

import com.example.spring_solo_project.model.Composer;
import com.example.spring_solo_project.repository.ComposerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ComposerController {


    private final ComposerRepository composerRepository;

    public ComposerController(ComposerRepository composerRepository){
        this.composerRepository = composerRepository;
    }

    @GetMapping("/composers")
    public List<Composer> getComposers(){
        return composerRepository.findAll();
    }

}
