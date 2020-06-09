package com.example.api.util;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.pagehelper.PageInfo;

public class PageJsonObject extends AbstractJsonObject{
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private PageInfo<?> info;

    public PageInfo<?> getInfo() {
        return info;
    }

    public void setInfo(PageInfo<?> info) {
        this.info = info;
    }
}
