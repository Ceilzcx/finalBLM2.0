package com.example.api.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "om_order_inf", schema = "blm", catalog = "")
public class OmOrderInfEntity implements Serializable {
    private Integer orderInfId;
    private Integer recipeId;
    private Integer orderId;
    private Integer orderRecipeNumber;

    @Id
    @Column(name = "order_inf_id", nullable = false)
    @GeneratedValue(generator = "JDBC")
    public Integer getOrderInfId() {
        return orderInfId;
    }

    public void setOrderInfId(Integer orderInfId) {
        this.orderInfId = orderInfId;
    }

    @Basic
    @Column(name = "recipe_id", nullable = true)
    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
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
    @Column(name = "order_recipe_number", nullable = true)
    public Integer getOrderRecipeNumber() {
        return orderRecipeNumber;
    }

    public void setOrderRecipeNumber(Integer orderRecipeNumber) {
        this.orderRecipeNumber = orderRecipeNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OmOrderInfEntity that = (OmOrderInfEntity) o;

        if (orderInfId != that.orderInfId) return false;
        if (recipeId != null ? !recipeId.equals(that.recipeId) : that.recipeId != null) return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (orderRecipeNumber != null ? !orderRecipeNumber.equals(that.orderRecipeNumber) : that.orderRecipeNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderInfId;
        result = 31 * result + (recipeId != null ? recipeId.hashCode() : 0);
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (orderRecipeNumber != null ? orderRecipeNumber.hashCode() : 0);
        return result;
    }
}
