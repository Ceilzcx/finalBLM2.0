package com.example.api.form;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ShopOrder implements Serializable {
    int orderId;
    String userTel;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    Timestamp orderCreateTime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    Timestamp orderEndTime;
    String orderStatus;
    String orderRemark;
}
