package com.lg.movies;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lg.movies.domain.MoviesType;
import com.lg.movies.service.MoviesTypeService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=LiuMoviesApplication.class)
public class MoviesTypeTest {

	@Autowired
	private MoviesTypeService moviesTypeService;
	
	@Test
	public void add() throws Exception {
		MoviesType moviesType = new MoviesType();
		moviesType.setTypeName("惊悚");
		moviesTypeService.save(moviesType);
	}
}
