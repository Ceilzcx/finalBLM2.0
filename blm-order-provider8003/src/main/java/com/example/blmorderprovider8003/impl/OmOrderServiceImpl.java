package com.example.blmorderprovider8003.impl;

import com.example.api.entity.OmOrderEntity;
import com.example.api.form.Order;
import com.example.api.form.OrderForm;
import com.example.api.form.OrderInfAllApp;
import com.example.api.form.ShopOrder;
import com.example.api.service.OmOrderService;
import com.example.blmorderprovider8003.dao.mapper.OmOrderMapper;
import com.example.blmorderprovider8003.dao.mapper2.OmOrderMapper2;
import com.github.pagehelper.PageHelper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

@Service
@Component
public class OmOrderServiceImpl implements OmOrderService {
    @Resource
    private OmOrderMapper mapper;

    @Resource
    private OmOrderMapper2 mapper2;

    @Override
    public List<Order> getOrderList(int userId) {
        return mapper2.getOrderList(userId);
    }

    @Override
    public List<ShopOrder> getOrderListByShopId(int shopId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return mapper2.getOrderListByShopId(shopId);
    }



    @Override
    public Integer insert(OrderForm form) {
        OmOrderEntity omOrderEntity = new OmOrderEntity();
        BeanUtils.copyProperties(form, omOrderEntity);
        omOrderEntity.setOrderStatus("下单");
        omOrderEntity.setOrderCreatetime(new Timestamp(System.currentTimeMillis()));
        return mapper.insert(omOrderEntity);
    }

    @Override
    public OrderInfAllApp getOrderByOrderId(int orderId) {
        return mapper2.getOrderByOrderIdApp(orderId);
    }

}
