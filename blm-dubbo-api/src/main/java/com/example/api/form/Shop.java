package com.example.api.form;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Shop implements Serializable {
    int shopId;
    String shopName;
    String shopAddress;
    String shopTel;
    Double shopRating;
    String shopNotice;
    byte[] shopTrademark;
    String shopStatus;
}
