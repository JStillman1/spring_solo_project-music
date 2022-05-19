package com.example.spring_solo_project.controller;

import com.example.spring_solo_project.model.Music;
import com.example.spring_solo_project.repository.MusicRepository;
import org.springframework.web.bind.annotation.GetMapping;
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


}
