package com.lg.movies.response;


import java.io.Serializable;

@SuppressWarnings("serial")
public class ReturnDto implements Serializable{
	//0:成功 1:失败    默认成功
	private String code=ResponseState.SUCCESS;
	
	private String msg="success";
	
	private Object data;
		
		

		public ReturnDto() {
			super();
		}

		
		
		public ReturnDto(String code, Object data) {
			super();
			this.code = code;
			this.data = data;
		}


		public ReturnDto(String code, String msg) {
			super();
			this.code = code;
			this.msg = msg;
		}



		public ReturnDto(String code, String msg, Object data) {
			super();
			this.code = code;
			this.msg = msg;
			this.data = data;
		}



		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public Object getData() {
			return data;
		}

		public void setData(Object data) {
			this.data = data;
		}
		
}
