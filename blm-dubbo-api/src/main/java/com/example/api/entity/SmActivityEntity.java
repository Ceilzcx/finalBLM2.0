package com.example.api.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sm_activity", schema = "blm", catalog = "")
public class SmActivityEntity implements Serializable {
    private Integer activityId;
    private Integer shopId;
    private Double activityCondition;
    private Double activityReduce;
    private Integer isActive;

    @Id
    @Column(name = "activity_id", nullable = false)
    @GeneratedValue(generator = "JDBC")
    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
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
    @Column(name = "activity_condition", nullable = true, precision = 0)
    public Double getActivityCondition() {
        return activityCondition;
    }

    public void setActivityCondition(Double activityCondition) {
        this.activityCondition = activityCondition;
    }

    @Basic
    @Column(name = "activity_reduce", nullable = true, precision = 0)
    public Double getActivityReduce() {
        return activityReduce;
    }

    public void setActivityReduce(Double activityReduce) {
        this.activityReduce = activityReduce;
    }

    @Basic
    @Column(name = "is_active", nullable = true)
    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SmActivityEntity entity = (SmActivityEntity) o;

        if (activityId != entity.activityId) return false;
        if (shopId != null ? !shopId.equals(entity.shopId) : entity.shopId != null) return false;
        if (activityCondition != null ? !activityCondition.equals(entity.activityCondition) : entity.activityCondition != null)
            return false;
        if (activityReduce != null ? !activityReduce.equals(entity.activityReduce) : entity.activityReduce != null)
            return false;
        if (isActive != null ? !isActive.equals(entity.isActive) : entity.isActive != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = activityId;
        result = 31 * result + (shopId != null ? shopId.hashCode() : 0);
        result = 31 * result + (activityCondition != null ? activityCondition.hashCode() : 0);
        result = 31 * result + (activityReduce != null ? activityReduce.hashCode() : 0);
        result = 31 * result + (isActive != null ? isActive.hashCode() : 0);
        return result;
    }
}
