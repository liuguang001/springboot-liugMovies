package com.lg.movies.service;

import java.util.concurrent.Future;

/**
 * @author 异步调用
 *
 */
public interface AsyncService {

	Future<String> one();

	Future<String> two();

	Future<String> three();

	Future<String> fore();

}
