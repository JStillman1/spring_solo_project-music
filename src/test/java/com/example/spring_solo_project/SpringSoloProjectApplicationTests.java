package com.example.spring_solo_project;

import com.example.spring_solo_project.model.Composer;
import com.example.spring_solo_project.model.Music;
import com.example.spring_solo_project.repository.ComposerRepository;
import com.example.spring_solo_project.repository.MusicRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringSoloProjectApplicationTests {

	@Autowired
	MusicRepository musicRepository;

	@Autowired
	ComposerRepository composerRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void dataSqlLoadsMusic(){
		List<Music> found = musicRepository.findAll();
		assertEquals(243,found.size());
	}

	@Test
	public void dataSqlLoadsComposers(){
		List<Composer> found = composerRepository.findAll();
		assertEquals(50, found.size());
	}

	@Test
	public void canFindMusicByTitle(){
		Music found = musicRepository.findByTitle("Fortress 2");
		assertEquals("Fortress 2", found.getTitle());
	}

	@Test
	public void canFindMusicByTitle_nonExistentTitle(){
		Music found = musicRepository.findByTitle("arenfaoiernfioanio");
		assertNull(found);
	}

	@Test
	public void canFilterByYear(){
		List<Music> found = musicRepository.findAllComposedAfterYear(2000);
		assertEquals(9, found.size());
	}

	@Test
	public void canFilterByYear_givenFuture(){
		List<Music> found = musicRepository.findAllComposedAfterYear(2100);
		assertTrue(found.isEmpty());
	}

}













