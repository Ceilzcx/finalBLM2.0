package com.example.api.service;

import com.example.api.entity.UmUserEntity;

import java.util.List;

public interface UmUserService {

    List<UmUserEntity> select(String userAccount, String userPwd);
}
