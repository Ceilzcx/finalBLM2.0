package com.example.blmorderprovider8003.impl;

import com.example.api.entity.OmOrderEntity;
import com.example.api.entity.OmOrderInfEntity;
import com.example.api.form.Order;
import com.example.api.form.OrderForm;
import com.example.api.form.OrderInfAllApp;
import com.example.api.form.ShopOrder;
import com.example.api.service.OmOrderServiceTransactional;
import com.example.api.service.SmRecipeServiceTransactional;
import com.example.blmorderprovider8003.dao.mapper.OmOrderInfMapper;
import com.example.blmorderprovider8003.dao.mapper.OmOrderMapper;
import com.example.blmorderprovider8003.dao.mapper2.OmOrderMapper2;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.mengyun.tcctransaction.api.Compensable;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

@Service(version = "2.0.0")
@Component
public class OmOrderServiceImpl2 implements OmOrderServiceTransactional {
    private Integer orderId;

    @Resource
    private OmOrderMapper orderMapper;

    @Resource
    private OmOrderMapper2 orderMapper2;

    @Resource
    private OmOrderInfMapper orderInfMapper1;

    @Reference(version = "2.0.0", check = false)
    private SmRecipeServiceTransactional smRecipeService;

    @Override
    public List<Order> getOrderList(int userId) {
        return orderMapper2.getOrderList(userId);
    }

    @Override
    public List<ShopOrder> getOrderListByShopId(int shopId) {
        return orderMapper2.getOrderListByShopId(shopId);
    }

    @Override
    @Compensable(confirmMethod = "confirmInsert", cancelMethod = "cancelInsert", asyncConfirm = true)
    @Transactional
    public Integer insert(OrderForm form) {
        OmOrderEntity omOrderEntity = new OmOrderEntity();
        BeanUtils.copyProperties(form, omOrderEntity);
        omOrderEntity.setOrderStatus("下单");
        omOrderEntity.setOrderCreatetime(new Timestamp(System.currentTimeMillis()));
        orderId=orderMapper.insert(omOrderEntity);
        for (OmOrderInfEntity omOrderInfEntity : form.getOrderInfList()) {
            smRecipeService.updateRecipeRemain(omOrderInfEntity.getRecipeId(),omOrderInfEntity.getOrderRecipeNumber());
        }
        for (OmOrderInfEntity omOrderInfEntity : form.getOrderInfList()) {
            omOrderInfEntity.setOrderId(orderId);
            orderInfMapper1.insert(omOrderInfEntity);
        }
        return orderId;
    }

    @Override
    @Transactional
    public Integer confirmInsert(OrderForm form){
        return orderId;
    }

    @Override
    @Transactional
    public Integer cancelInsert(OrderForm form){
        if(orderId!=null){
            OmOrderEntity omOrderEntity = new OmOrderEntity();
            omOrderEntity.setOrderId(orderId);
            orderMapper.deleteByExample(omOrderEntity);

            OmOrderInfEntity omOrderInfEntity = new OmOrderInfEntity();
            omOrderInfEntity.setOrderId(orderId);
            orderInfMapper1.deleteByExample(omOrderInfEntity);
        }
        return 0;
    }


    @Override
    public OrderInfAllApp getOrderByOrderId(int orderId) {
        return orderMapper2.getOrderByOrderIdApp(orderId);
    }
}
