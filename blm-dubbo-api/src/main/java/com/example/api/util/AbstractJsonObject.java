package com.example.api.util;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AbstractJsonObject implements Serializable {

	private int code;
	// 
	private String msg;

	private String time;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setContent(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public void setStatusObject(StatusObject statusObject) {
		this.code = statusObject.getCode();
		this.msg = statusObject.getMsg();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.time=sdf.format(new Date());
	}
}
