package com.example.api.util;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class ListJsonObject extends AbstractJsonObject{

	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private List<?> data;

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}


}
