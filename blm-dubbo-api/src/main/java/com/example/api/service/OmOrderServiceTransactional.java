package com.example.api.service;

import com.example.api.form.*;

import java.util.List;

public interface OmOrderServiceTransactional {

    List<Order> getOrderList(int userId);

    List<ShopOrder> getOrderListByShopId(int shopId);

    Integer insert(OrderForm form);

    Integer confirmInsert(OrderForm form);

    Integer cancelInsert(OrderForm form);

    OrderInfAllApp getOrderByOrderId(int orderId);

    List<OrderApp> getOrderListByUserId(int userId);
}
