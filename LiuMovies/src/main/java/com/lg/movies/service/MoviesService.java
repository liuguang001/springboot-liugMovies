package com.lg.movies.service;

import org.springframework.data.domain.Page;

import com.lg.movies.domain.Movies;

public interface MoviesService {
	
	public Page<Movies> queryByCondition(Movies movies,Integer pageNo,Integer pageSize);

	public void saveMovies(Movies movies) throws Exception;
}
