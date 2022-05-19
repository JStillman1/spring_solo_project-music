package com.example.spring_solo_project.controller;

import com.example.spring_solo_project.model.Music;
import com.example.spring_solo_project.repository.MusicRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MusicController {

    private final MusicRepository musicRepository;
    public MusicController(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @GetMapping("/music")
    public List<Music> getMusic(){
        return musicRepository.findAll();
    }

    @GetMapping("/music/{title}")
    public Music findMusicByTitle(@PathVariable String title){
        return musicRepository.findByTitle(title);
    }

    @DeleteMapping("/music/delete/{id}")
    public void deleteMusicById(@PathVariable Long id){
        musicRepository.deleteById(id);
    }

}
