package com.example.api.form;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ShopEva implements Serializable {
    int userId;
    String userName;
    byte[] userImage;
    int shopEvaId;
    String content;
    byte[] shopEvaImage;
    double shopEvaRating;
}
