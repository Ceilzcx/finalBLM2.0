package com.example.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;

@Entity
@Table(name = "sm_shop", schema = "blm", catalog = "")
public class SmShopEntity {
    private Integer shopId;
    private String shopName;
    @JsonIgnore
    private String shopPwd;
    private String shopAddress;
    private String shopTel;
    private Double shopRating;
    private String shopNotice;
    private byte[] shopTrademark;
    private String shopStatus;

    public Timestamp getShopLogintime() {
        return shopLogintime;
    }

    public void setShopLogintime(Timestamp shopLogintime) {
        this.shopLogintime = shopLogintime;
    }

    private Timestamp shopLogintime;

    @Id
    @Column(name = "shop_id", nullable = false)
    @GeneratedValue(generator = "JDBC")
    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    @Basic
    @Column(name = "shop_name", nullable = true, length = 50)
    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    @Basic
    @Column(name = "shop_pwd", nullable = true, length = 50)
    public String getShopPwd() {
        return shopPwd;
    }

    public void setShopPwd(String shopPwd) {
        this.shopPwd = shopPwd;
    }

    @Basic
    @Column(name = "shop_address", nullable = true, length = 255)
    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    @Basic
    @Column(name = "shop_tel", nullable = true, length = 20)
    public String getShopTel() {
        return shopTel;
    }

    public void setShopTel(String shopTel) {
        this.shopTel = shopTel;
    }

    @Basic
    @Column(name = "shop_rating", nullable = true, precision = 0)
    public Double getShopRating() {
        return shopRating;
    }

    public void setShopRating(Double shopRating) {
        this.shopRating = shopRating;
    }

    @Basic
    @Column(name = "shop_notice", nullable = true, length = 500)
    public String getShopNotice() {
        return shopNotice;
    }

    public void setShopNotice(String shopNotice) {
        this.shopNotice = shopNotice;
    }

    @Basic
    @Column(name = "shop_trademark", nullable = true)
    public byte[] getShopTrademark() {
        return shopTrademark;
    }

    public void setShopTrademark(byte[] shopTrademark) {
        this.shopTrademark = shopTrademark;
    }

    @Basic
    @Column(name = "shop_status", nullable = true, length = 20)
    public String getShopStatus() {
        return shopStatus;
    }

    public void setShopStatus(String shopStatus) {
        this.shopStatus = shopStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SmShopEntity that = (SmShopEntity) o;

        if (shopId != that.shopId) return false;
        if (shopName != null ? !shopName.equals(that.shopName) : that.shopName != null) return false;
        if (shopPwd != null ? !shopPwd.equals(that.shopPwd) : that.shopPwd != null) return false;
        if (shopAddress != null ? !shopAddress.equals(that.shopAddress) : that.shopAddress != null) return false;
        if (shopTel != null ? !shopTel.equals(that.shopTel) : that.shopTel != null) return false;
        if (shopRating != null ? !shopRating.equals(that.shopRating) : that.shopRating != null) return false;
        if (shopNotice != null ? !shopNotice.equals(that.shopNotice) : that.shopNotice != null) return false;
        if (!Arrays.equals(shopTrademark, that.shopTrademark)) return false;
        if (shopStatus != null ? !shopStatus.equals(that.shopStatus) : that.shopStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shopId;
        result = 31 * result + (shopName != null ? shopName.hashCode() : 0);
        result = 31 * result + (shopPwd != null ? shopPwd.hashCode() : 0);
        result = 31 * result + (shopAddress != null ? shopAddress.hashCode() : 0);
        result = 31 * result + (shopTel != null ? shopTel.hashCode() : 0);
        result = 31 * result + (shopRating != null ? shopRating.hashCode() : 0);
        result = 31 * result + (shopNotice != null ? shopNotice.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(shopTrademark);
        result = 31 * result + (shopStatus != null ? shopStatus.hashCode() : 0);
        return result;
    }
}
