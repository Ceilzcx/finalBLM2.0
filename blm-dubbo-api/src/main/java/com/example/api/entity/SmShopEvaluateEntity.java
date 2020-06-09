package com.example.api.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;

@Entity
@Table(name = "sm_shop_evaluate", schema = "blm", catalog = "")
public class SmShopEvaluateEntity implements Serializable {
    private Integer evaluateId;
    private Integer shopId;
    private Integer userId;
    private Integer orderId;
    private Double evaluateRating;
    private String evaluateContent;
    private byte[] evaluateImage;

    @Id
    @Column(name = "evaluate_id", nullable = false)
    @GeneratedValue(generator = "JDBC")
    public Integer getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(Integer evaluateId) {
        this.evaluateId = evaluateId;
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
    @Column(name = "order_id", nullable = true)
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "evaluate_rating", nullable = true, precision = 0)
    public Double getEvaluateRating() {
        return evaluateRating;
    }

    public void setEvaluateRating(Double evaluateRating) {
        this.evaluateRating = evaluateRating;
    }

    @Basic
    @Column(name = "evaluate_content", nullable = true, length = 1024)
    public String getEvaluateContent() {
        return evaluateContent;
    }

    public void setEvaluateContent(String evaluateContent) {
        this.evaluateContent = evaluateContent;
    }

    @Basic
    @Column(name = "evaluate_image", nullable = true)
    public byte[] getEvaluateImage() {
        return evaluateImage;
    }

    public void setEvaluateImage(byte[] evaluateImage) {
        this.evaluateImage = evaluateImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SmShopEvaluateEntity that = (SmShopEvaluateEntity) o;

        if (evaluateId != that.evaluateId) return false;
        if (shopId != null ? !shopId.equals(that.shopId) : that.shopId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (evaluateRating != null ? !evaluateRating.equals(that.evaluateRating) : that.evaluateRating != null)
            return false;
        if (evaluateContent != null ? !evaluateContent.equals(that.evaluateContent) : that.evaluateContent != null)
            return false;
        if (!Arrays.equals(evaluateImage, that.evaluateImage)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = evaluateId;
        result = 31 * result + (shopId != null ? shopId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (evaluateRating != null ? evaluateRating.hashCode() : 0);
        result = 31 * result + (evaluateContent != null ? evaluateContent.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(evaluateImage);
        return result;
    }
}
