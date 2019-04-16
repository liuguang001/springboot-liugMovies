package com.lg.movies;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lg.movies.exception.MovException;
import com.lg.movies.response.ResponseState;
import com.lg.movies.response.ReturnDto;

/**
 *统一异常处理
 */
@ControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ReturnDto error(HttpServletRequest request, HttpServletResponse response,Exception e) {
    	ReturnDto returnDto=new ReturnDto();
    	returnDto.setCode(ResponseState.FAIL);
		if (e instanceof MovException) {
			returnDto.setMsg(e.getMessage());
		}else {
			e.printStackTrace();
			returnDto.setMsg("系统异常,请稍后重试!");
		}
		return returnDto;
    }
}