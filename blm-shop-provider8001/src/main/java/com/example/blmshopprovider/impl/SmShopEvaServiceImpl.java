package com.example.blmshopprovider.impl;

import com.example.api.form.ShopEva;
import com.example.api.service.SmShopEvaService;
import com.example.blmshopprovider.dao.mapper2.SmShopEvaMapper2;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Service
@Component
public class SmShopEvaServiceImpl implements SmShopEvaService {
    @Resource
    private SmShopEvaMapper2 mapper2;

    @Override
    public List<ShopEva> findAllByShopId(int shopId) {
        return mapper2.getShopEva(shopId);
    }
}
