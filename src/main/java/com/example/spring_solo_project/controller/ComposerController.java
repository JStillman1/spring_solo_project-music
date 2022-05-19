package com.example.spring_solo_project.controller;

import com.example.spring_solo_project.model.Composer;
import com.example.spring_solo_project.repository.ComposerRepository;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/composer")
public class ComposerController {


    private final ComposerRepository composerRepository;

    public ComposerController(ComposerRepository composerRepository){
        this.composerRepository = composerRepository;
    }

    @GetMapping
    public List<Composer> getComposers(@RequestParam(required = false, name = "id") Long id){
        if(id != null){
            return List.of(composerRepository.findById(id)
                    .orElseThrow(() -> new IllegalStateException(
                            "Composer Id does not exist"
                    )));
        }
        return composerRepository.findAll();
    }


    @DeleteMapping("/delete/{id}")
    public void deleteComposerById(@PathVariable Long id){
        composerRepository.deleteById(id);
    }

    @PostMapping
    public void createComposer(@RequestBody Composer composer){
        composerRepository.save(composer);
    }

    @PutMapping("/{id}")
    @Transactional
    public void updateComposer(@PathVariable Long id,
                               @RequestParam(required = false) String firstName,
                               @RequestParam(required = false) String lastName,
                               @RequestParam(required = false) Date dob){
        Composer composer = composerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Composer with ID " + id + " does not exist"));
        if(firstName != null){
            composer.setFirstName(firstName);
        }
        if(lastName != null){
            composer.setLastName(lastName);
        }
        if(dob != null){
            composer.setDob(dob);
        }
    }
}
