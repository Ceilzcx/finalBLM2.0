package com.example.blmshopprovider.impl;

import com.example.api.entity.SmActivityEntity;
import com.example.api.form.Activity;
import com.example.api.service.SmActivityService;
import com.example.blmshopprovider.dao.mapper.SmActivityMapper;
import com.example.blmshopprovider.dao.mapper2.SmActivityMapper2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SmActivityServiceImpl implements SmActivityService {
    @Resource
    private SmActivityMapper mapper;
    @Resource
    private SmActivityMapper2 mapper2;

    @Override
    public List<Activity> findAllByShopId(int shopId) {
        SmActivityEntity selectEntity = new SmActivityEntity();
        selectEntity.setShopId(shopId);
        List<SmActivityEntity> entities = mapper2.select(selectEntity);
        List<Activity> res = new ArrayList<>();
        for (SmActivityEntity entity : entities) {
            Activity activity = new Activity();
            BeanUtils.copyProperties(entity, activity);
            res.add(activity);
        }
        return res;
    }

    @Override
    public void updateActivityStatus() {
    }
}
