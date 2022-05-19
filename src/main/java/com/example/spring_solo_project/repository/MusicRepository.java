package com.example.spring_solo_project.repository;

import com.example.spring_solo_project.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MusicRepository extends JpaRepository<Music, Long> {

    Music findByTitle(String title);


}
