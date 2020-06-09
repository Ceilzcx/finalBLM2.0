package com.example.api.form;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ShopForm implements Serializable {
    int shopId;
    String shopName;
    String shopAddress;
    String shopTel;
    String shopNotice;
}
