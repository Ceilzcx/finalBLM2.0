package com.example.blmshopprovider.impl;

import com.example.api.form.ShopEva;
import com.example.api.service.SmShopEvaService;
import com.example.blmshopprovider.dao.mapper2.SmShopEvaMapper2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SmShopEvaServiceImpl implements SmShopEvaService {
    @Resource
    private SmShopEvaMapper2 mapper2;

    @Override
    public List<ShopEva> findAllByShopId(int shopId) {
        return mapper2.getShopEva(shopId);
    }
}
