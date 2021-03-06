package com.example.spring_solo_project.controller;

import com.example.spring_solo_project.model.Music;
import com.example.spring_solo_project.repository.MusicRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/music")
public class MusicController {

    private final MusicRepository musicRepository;
    public MusicController(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @GetMapping
    public List<Music> getMusic( @RequestParam(required = false, name = "year") Integer year){

        //  /music?year=2000
        if(year != null){
            return musicRepository.findAllComposedAfterYear(year);
        }
        // /music
        return musicRepository.findAll();
    }

    @GetMapping("/{title}")
    public Music findMusicByTitle(@PathVariable String title){
        return musicRepository.findByTitle(title);
    }

    @PostMapping
    public void createMusic(@RequestBody Music music){
        musicRepository.save(music);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMusicById(@PathVariable Long id){
        musicRepository.deleteById(id);
    }

//    @GetMapping("/music/filter/{year}")
//    public List<Music> findMusicComposedAfterYear(@PathVariable int year){
//        return musicRepository.findAllComposedAfterYear(year);
//    }

}
