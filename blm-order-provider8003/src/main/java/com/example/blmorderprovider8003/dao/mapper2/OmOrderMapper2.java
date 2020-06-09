package com.example.blmorderprovider8003.dao.mapper2;


import com.example.api.entity.OmOrderEntity;
import com.example.api.form.Order;
import com.example.api.form.OrderApp;
import com.example.api.form.OrderInfAllApp;
import com.example.api.form.ShopOrder;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface OmOrderMapper2 extends Mapper<OmOrderEntity> {

    @Select("select shop.shop_name, o.order_id, o.order_createtime, o.order_endtime, o.order_status, o.order_remark from om_order o left outer join sm_shop shop on shop.shop_id = o.shop_id where o.user_id = #{userId}")
    @Results({
            @Result(property = "shopName", column = "shop_name"),
            @Result(property = "orderId", column = "order_id"),
            @Result(property = "orderCreateTime", column = "order_createtime"),
            @Result(property = "orderEndTime", column = "order_endtime"),
            @Result(property = "orderStatus", column = "order_status"),
            @Result(property = "orderRemark", column = "order_remark"),
    })
    List<Order> getOrderList(int userId);

    @Select("select u.user_tel, o.order_id, o.order_createtime, o.order_endtime, o.order_status, o.order_remark from om_order o left outer join um_user u on u.user_id = o.user_id where o.shop_id = #{shopId}")
    @Results({
            @Result(property = "userTel", column = "user_tel"),
            @Result(property = "orderId", column = "order_id"),
            @Result(property = "orderCreateTime", column = "order_createtime"),
            @Result(property = "orderEndTime", column = "order_endtime"),
            @Result(property = "orderStatus", column = "order_status"),
            @Result(property = "orderRemark", column = "order_remark"),
    })
    List<ShopOrder> getOrderListByShopId(int shopId);

    @Select("select o.order_id,o.shop_id,s.shop_name,s.shop_trademark,o.order_createtime,o.order_status,o.order_money from sm_shop s,om_order o where s.shop_id=o.shop_id AND user_id=#{userId}")
    @Results({
            @Result(property = "orderId", column = "order_id"),
            @Result(property = "shopId", column = "shop_id"),
            @Result(property = "shopName", column = "shop_name"),
            @Result(property = "shopTrademark", column = "shop_trademark"),
            @Result(property = "orderCreateTime", column = "order_createTime"),
            @Result(property = "orderStatus", column = "order_status"),
            @Result(property = "orderMoney", column = "order_money"),
    })
    List<OrderApp> getOrderListByUserId(int userId);

    @Select("select s.shop_name,o.order_money from om_order o,sm_shop s where o.shop_id=s.shop_id and o.order_id=#{orderId}")
    @Results({
            @Result(property = "shopName", column = "shop_name"),
            @Result(property = "orderMoney", column = "order_money")
    })
    OrderInfAllApp getOrderByOrderIdApp(int orderId);
}
