package com.example.blmorderprovider8003.impl;


import com.example.api.entity.OmOrderInfEntity;
import com.example.api.form.OrderInf;
import com.example.api.form.OrderInfApp;
import com.example.api.service.OmOrderInfService;
import com.example.blmorderprovider8003.dao.mapper.OmOrderInfMapper;
import com.example.blmorderprovider8003.dao.mapper2.OmOrderInfMapper2;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Service
@Component
public class OmOrderInfServiceImpl implements OmOrderInfService {
    @Resource
    private OmOrderInfMapper mapper;

    @Resource
    private OmOrderInfMapper2 mapper2;

    @Override
    public List<OrderInf> getOrderInfName(int orderId) {
        return mapper2.getOrderInfName(orderId);
    }

    @Override
    public void insertSelective(OmOrderInfEntity form) {
        mapper.insertSelective(form);
    }

    @Override
    public List<OrderInfApp> getOrderInfAll(int orderId) {
        return mapper2.getOrderInfByOrderIdApp(orderId);
    }

    @Override
    public Integer insert(OmOrderInfEntity omOrderInfEntity) {
        return mapper.insert(omOrderInfEntity);
    }
}
