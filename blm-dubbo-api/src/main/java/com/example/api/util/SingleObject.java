package com.example.api.util;

import com.alibaba.fastjson.annotation.JSONField;

public class SingleObject extends AbstractJsonObject {
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Object data;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}



}
