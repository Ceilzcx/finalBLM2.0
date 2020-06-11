package com.example.api.service;

import com.example.api.entity.OmOrderInfEntity;
import com.example.api.form.OrderInf;
import com.example.api.form.OrderInfApp;
//import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface OmOrderInfService {
    List<OrderInf>  getOrderInfName(int orderId);

    void insertSelective(OmOrderInfEntity form);

    List<OrderInfApp> getOrderInfAll(int orderId);

    Integer insert(OmOrderInfEntity omOrderInfEntity);
}
