package com.example.api.util;

/**
 * 状态对象
 */
public class StatusObject {
	// 状态码
	private int code;

	// 状态信息
	private String msg;

	public StatusObject(int cODE_SUCCESS, String msg) {
		super();
		this.code = cODE_SUCCESS;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
