package com.khidi.common.exception;

/**
 * 自定义异常
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年10月27日 下午10:11:27
 */
public class MyNullException extends NullPointerException{
	private static final long serialVersionUID = 1L;

    private String msg;
    private int code = 0;



	public MyNullException(int code, String msg) {
		super();
		this.msg = msg;
		this.code = code;
	}



	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	
}
