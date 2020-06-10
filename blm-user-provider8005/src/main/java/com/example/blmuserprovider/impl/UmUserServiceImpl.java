package com.example.blmuserprovider.impl;

import com.example.api.entity.UmUserEntity;
import com.example.api.service.UmUserService;
import com.example.blmuserprovider.dao.mapper.UmUserMapper;
import com.example.blmuserprovider.dao.mapper2.UmUserMapper2;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Service
@Component
public class UmUserServiceImpl implements UmUserService {
    @Resource
    private UmUserMapper mapper;
    @Resource
    private UmUserMapper2 mapper2;

    @Override
    public List<UmUserEntity> select(String userAccount, String userPwd) {
        UmUserEntity entity = new UmUserEntity();
        entity.setUserAccount(userAccount);
        entity.setUserPwd(userPwd);
        List<UmUserEntity> entities = mapper2.select(entity);
        return entities;
    }
}
