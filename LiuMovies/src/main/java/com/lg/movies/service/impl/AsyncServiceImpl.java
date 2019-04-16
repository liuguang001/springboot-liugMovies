package com.lg.movies.service.impl;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import com.lg.movies.service.AsyncService;

@Service
public class AsyncServiceImpl implements AsyncService{

	
	@Async
	@Override
	public Future<String> one(){
		System.out.println("one");
		return new AsyncResult<String>("one");
	}
	
	@Async
	@Override
	public Future<String> two(){
		System.out.println("two");
		return new AsyncResult<String>("two");
	}
	
	@Async
	@Override
	public Future<String> three(){
		System.out.println("three");
		return new AsyncResult<String>("three");
	}
	
	@Async
	@Override
	public Future<String> fore(){
		System.out.println("fore");
		return new AsyncResult<String>("fore");
	}
}
