package com.lg.movies.dao;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lg.movies.domain.MoviesType;


@CacheConfig(cacheNames="moviesType")
public interface MoviesTypeDao extends JpaRepository<MoviesType, Integer> {
	
	@Cacheable
	public MoviesType findByTypeName(String typeName);

	@Cacheable
	public List<MoviesType> findByState(Integer state);
	
	@CachePut
	public MoviesType save(MoviesType moviesType);
}
