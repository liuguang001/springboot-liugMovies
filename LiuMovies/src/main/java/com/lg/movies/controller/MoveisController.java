package com.lg.movies.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lg.movies.domain.Movies;
import com.lg.movies.response.BaseController;
import com.lg.movies.response.ReturnDto;
import com.lg.movies.service.MoviesService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/movies")
public class MoveisController extends BaseController{
	
	private final static Logger logger = LoggerFactory.getLogger(MoveisController.class);
	
	@Autowired
	private MoviesService moviesService;

	@ApiOperation(value="多条件查询")
	@RequestMapping(value="/queryByCondition",method=RequestMethod.POST)
	public ReturnDto queryByCondition(@RequestBody Movies movies,@RequestParam(defaultValue="1",required=true)Integer pageNo,@RequestParam(defaultValue="10",required=true)Integer pageSize){
		logger.info("多条件查询电影:{}",movies);
		Page<Movies> page = moviesService.queryByCondition(movies, pageNo, pageSize);
		return getSuccessReturnDto(page);
	}
	
	@ApiOperation(value="添加电影")
	@RequestMapping(value="/addMovies",method=RequestMethod.POST)
	public ReturnDto addMovies(@RequestBody Movies movies)throws Exception{
		logger.info("添加电影:{}",movies);
		moviesService.saveMovies(movies);
		return getSuccessReturnDto();
	}
	
}
