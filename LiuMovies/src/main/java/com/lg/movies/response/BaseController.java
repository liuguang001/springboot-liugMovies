package com.lg.movies.response;

public class BaseController {

	public ReturnDto returnDto=new ReturnDto();

	public ReturnDto getReturnDto() {
		return returnDto;
	}

	public void setReturnDto(ReturnDto returnDto) {
		this.returnDto = returnDto;
	}

	/**返回请求失败实体带消息
	 * @param message
	 */
	public ReturnDto getFailReturnDto(String message) {
		this.returnDto.setCode(ResponseState.FAIL);
		this.returnDto.setMsg(message);
		return this.returnDto;
	}
	
	/**
	 * 返回请求成功实体
	 */
	public ReturnDto getSuccessReturnDto() {
		this.returnDto.setCode(ResponseState.SUCCESS);
		return this.returnDto;
	}
	
	/**
	 * 返回请求成功实体带数据
	 */
	public ReturnDto getSuccessReturnDto(Object data) {
		this.returnDto.setCode(ResponseState.SUCCESS);
		this.returnDto.setData(data);
		return this.returnDto;
	}
	
	/**返回未登录错误
	 * @return
	 */
	public ReturnDto getNeedLoginReturnDto(){
		this.returnDto.setCode(ResponseState.NEED_LOGIN);
		this.returnDto.setMsg("请先登录!");
		return this.returnDto;
	}
	
	/**返回找不到地址错误
	 * @return
	 */
	public ReturnDto getNotFoundReturnDto(){
		this.returnDto.setCode(ResponseState.NOT_FOUND);
		this.returnDto.setMsg("没有该服务!");
		return this.returnDto;
	}
	
}
