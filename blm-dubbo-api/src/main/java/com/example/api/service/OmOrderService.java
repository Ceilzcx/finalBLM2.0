package com.example.api.service;

import com.example.api.form.Order;
import com.example.api.form.OrderForm;
import com.example.api.form.OrderInfAllApp;
import com.example.api.form.ShopOrder;
//import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface OmOrderService {

    List<Order> getOrderList(int userId);

    List<ShopOrder> getOrderListByShopId(int shopId);

    Integer insert(OrderForm form);

    OrderInfAllApp getOrderByOrderId(int orderId);

}
