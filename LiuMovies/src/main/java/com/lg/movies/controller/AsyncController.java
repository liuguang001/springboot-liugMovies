package com.lg.movies.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lg.movies.service.AsyncService;

import io.swagger.annotations.ApiOperation;

/**
 * @author 异步调用测试
 *
 */
@RestController
@RequestMapping("/async")
public class AsyncController {
	@Autowired
	private AsyncService asyncService;
	
	@ApiOperation(value="异步处理测试")
	@RequestMapping(value="asyncHello",method=RequestMethod.GET)
	public String asyncHello() throws Exception {
		asyncService.one();
		asyncService.two();
		asyncService.three();
		asyncService.fore();
		return "asyncHello";
	}

}
