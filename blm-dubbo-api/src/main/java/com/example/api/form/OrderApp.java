package com.example.api.form;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderApp implements Serializable {
    Integer orderId;
    Integer shopId;
    String shopName;
    byte[] shopTrademark;
    Timestamp orderCreateTime;
    String orderStatus;
    Double orderMoney;
}
