package com.lg.movies.service;

import java.util.List;

import com.lg.movies.domain.MoviesType;

public interface MoviesTypeService {

	void save(MoviesType moviesType) throws Exception;

	Boolean validTypeName(int type, String typeName, Integer id) throws Exception;

	List<MoviesType> listAll();
}
