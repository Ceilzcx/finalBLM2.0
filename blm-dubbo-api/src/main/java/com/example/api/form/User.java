package com.example.api.form;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements Serializable {
    int userId;
    String userName;
    String userTel;
    String userAddress;
    byte[] userImage;
}
