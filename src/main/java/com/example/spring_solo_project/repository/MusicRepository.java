package com.example.spring_solo_project.repository;

import com.example.spring_solo_project.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.Year;
import java.util.List;

public interface MusicRepository extends JpaRepository<Music, Long> {

    Music findByTitle(String title);

    @Query(value = "SELECT * FROM MUSIC WHERE YEAR_OF_COMPOSITION > ?1", nativeQuery = true)
    List<Music> findAllComposedAfterYear(int year);


}
