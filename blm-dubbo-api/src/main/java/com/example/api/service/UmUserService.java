package com.example.api.service;

import com.example.api.util.AbstractJsonObject;

public interface UmUserService {

    AbstractJsonObject select(String userAccount, String userPwd);
}
