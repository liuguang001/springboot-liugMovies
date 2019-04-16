package com.lg.movies.dao;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.lg.movies.domain.Movies;

@CacheConfig(cacheNames="movies")
public interface MoviesDao extends JpaRepository<Movies, Integer>,JpaSpecificationExecutor<Movies>{
	
	@Cacheable
	public  Page<Movies> findAll(Specification<Movies> spec, Pageable pageable);
	
	@CachePut
	public Movies save(Movies movies);
	
}
