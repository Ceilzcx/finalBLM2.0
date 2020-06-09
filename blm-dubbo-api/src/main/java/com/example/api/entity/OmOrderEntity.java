package com.example.api.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "om_order", schema = "blm", catalog = "")
public class OmOrderEntity implements Serializable {
    @Id
    @Column(name = "order_id", nullable = false)
    @GeneratedValue(generator = "JDBC")
    private Integer orderId;
    private Integer shopId;
    private Integer userId;
    @JsonIgnore
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp orderCreatetime;
    @JsonIgnore
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp orderEndtime;
    private String orderStatus;
    private String orderRemark;
    private Double orderMoney;
    private Double orderReduce;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "shop_id", nullable = true)
    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    @Basic
    @Column(name = "user_id", nullable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "order_createtime", nullable = true)
    public Timestamp getOrderCreatetime() {
        return orderCreatetime;
    }

    public void setOrderCreatetime(Timestamp orderCreatetime) {
        this.orderCreatetime = orderCreatetime;
    }

    @Basic
    @Column(name = "order_endtime", nullable = true)
    public Timestamp getOrderEndtime() {
        return orderEndtime;
    }

    public void setOrderEndtime(Timestamp orderEndtime) {
        this.orderEndtime = orderEndtime;
    }

    @Basic
    @Column(name = "order_status", nullable = true, length = 20)
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Basic
    @Column(name = "order_remark", nullable = true, length = 200)
    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }

    @Basic
    @Column(name = "order_money", nullable = true)
    public Double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Double orderMoney) {
        this.orderMoney = orderMoney;
    }

    @Basic
    @Column(name = "order_reduce", nullable = true)
    public Double getOrderReduce() {
        return orderReduce;
    }

    public void setOrderReduce(Double orderReduce) {
        this.orderReduce = orderReduce;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OmOrderEntity that = (OmOrderEntity) o;

        if (orderId != that.orderId) return false;
        if (shopId != null ? !shopId.equals(that.shopId) : that.shopId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (orderCreatetime != null ? !orderCreatetime.equals(that.orderCreatetime) : that.orderCreatetime != null)
            return false;
        if (orderEndtime != null ? !orderEndtime.equals(that.orderEndtime) : that.orderEndtime != null) return false;
        if (orderStatus != null ? !orderStatus.equals(that.orderStatus) : that.orderStatus != null) return false;
        if (orderRemark != null ? !orderRemark.equals(that.orderRemark) : that.orderRemark != null) return false;
        if (orderMoney != that.orderMoney) return false;
        if (orderReduce != that.orderReduce) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + (shopId != null ? shopId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (orderCreatetime != null ? orderCreatetime.hashCode() : 0);
        result = 31 * result + (orderEndtime != null ? orderEndtime.hashCode() : 0);
        result = 31 * result + (orderStatus != null ? orderStatus.hashCode() : 0);
        result = 31 * result + (orderRemark != null ? orderRemark.hashCode() : 0);
        result = 31 * result + (orderMoney!= null ? orderMoney.hashCode() : 0);
        result = 31 * result + (orderReduce!= null ? orderReduce.hashCode() : 0);
        return result;
    }
}
