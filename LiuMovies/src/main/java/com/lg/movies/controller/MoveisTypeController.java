package com.lg.movies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lg.movies.domain.MoviesType;
import com.lg.movies.response.BaseController;
import com.lg.movies.response.ReturnDto;
import com.lg.movies.service.MoviesTypeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("moviesType")
public class MoveisTypeController extends BaseController{

	@Autowired
	private MoviesTypeService moviesTypeService;
	
	@ApiOperation(value="类型列表")
	@RequestMapping(value="/listAll",method=RequestMethod.GET)
	public ReturnDto listAll() {
		List<MoviesType> moveisTypes=moviesTypeService.listAll();
		return getSuccessReturnDto(moveisTypes);
	}
	
	
	@ApiOperation(value="新增类型")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ReturnDto add(@RequestBody MoviesType moviesType) throws Exception {
		moviesTypeService.save(moviesType);
		return getSuccessReturnDto();
	}
	
}
