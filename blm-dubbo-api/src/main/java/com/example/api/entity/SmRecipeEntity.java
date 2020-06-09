package com.example.api.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;

@Entity
@Table(name = "sm_recipe", schema = "blm", catalog = "")
public class SmRecipeEntity implements Serializable {
    private Integer recipeId;
    private Integer shopId;
    private String recipeName;
    private Double recipePrice;
    private Integer monthlySale;
    private String recipeIntroduction;
    private byte[] recipeImage;
    private Integer recipeRemain;
    private Double recipeDiscount;
    private String recipeStatus;
    private Integer frozenRemain;

    @Id
    @Column(name = "recipe_id", nullable = false)
    @GeneratedValue(generator = "JDBC")
    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
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
    @Column(name = "recipe_name", nullable = true, length = 50)
    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    @Basic
    @Column(name = "recipe_price", nullable = true, precision = 0)
    public Double getRecipePrice() {
        return recipePrice;
    }

    public void setRecipePrice(Double recipePrice) {
        this.recipePrice = recipePrice;
    }

    @Basic
    @Column(name = "monthly_sale", nullable = true)
    public Integer getMonthlySale() {
        return monthlySale;
    }

    public void setMonthlySale(Integer monthlySale) {
        this.monthlySale = monthlySale;
    }

    @Basic
    @Column(name = "recipe_introduction", nullable = true, length = 200)
    public String getRecipeIntroduction() {
        return recipeIntroduction;
    }

    public void setRecipeIntroduction(String recipeIntroduction) {
        this.recipeIntroduction = recipeIntroduction;
    }

    @Basic
    @Column(name = "recipe_image", nullable = true)
    public byte[] getRecipeImage() {
        return recipeImage;
    }

    public void setRecipeImage(byte[] recipeImage) {
        this.recipeImage = recipeImage;
    }

    @Basic
    @Column(name = "recipe_remain", nullable = true)
    public Integer getRecipeRemain() {
        return recipeRemain;
    }

    public void setRecipeRemain(Integer recipeRemain) {
        this.recipeRemain = recipeRemain;
    }

    @Basic
    @Column(name = "recipe_discount", nullable = true, precision = 0)
    public Double getRecipeDiscount() {
        return recipeDiscount;
    }

    public void setRecipeDiscount(Double recipeDiscount) {
        this.recipeDiscount = recipeDiscount;
    }

    @Basic
    @Column(name = "recipe_status", nullable = true, length = 20)
    public String getRecipeStatus() {
        return recipeStatus;
    }

    public void setRecipeStatus(String recipeStatus) {
        this.recipeStatus = recipeStatus;
    }

    @Basic
    @Column(name = "frozen_remain", nullable = true)
    public Integer getFrozenRemain() {
        return frozenRemain;
    }

    @Basic
    @Column(name = "frozen_remain", nullable = true)
    public void setIsFrozenRemain(Integer frozenRemain) {
        this.frozenRemain = frozenRemain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SmRecipeEntity that = (SmRecipeEntity) o;

        if (recipeId != that.recipeId) return false;
        if (shopId != null ? !shopId.equals(that.shopId) : that.shopId != null) return false;
        if (recipeName != null ? !recipeName.equals(that.recipeName) : that.recipeName != null) return false;
        if (recipePrice != null ? !recipePrice.equals(that.recipePrice) : that.recipePrice != null) return false;
        if (monthlySale != null ? !monthlySale.equals(that.monthlySale) : that.monthlySale != null) return false;
        if (recipeIntroduction != null ? !recipeIntroduction.equals(that.recipeIntroduction) : that.recipeIntroduction != null)
            return false;
        if (!Arrays.equals(recipeImage, that.recipeImage)) return false;
        if (recipeRemain != null ? !recipeRemain.equals(that.recipeRemain) : that.recipeRemain != null) return false;
        if (recipeDiscount != null ? !recipeDiscount.equals(that.recipeDiscount) : that.recipeDiscount != null)
            return false;
        if (recipeStatus != null ? !recipeStatus.equals(that.recipeStatus) : that.recipeStatus != null) return false;
        if (frozenRemain != null ? !frozenRemain.equals(that.frozenRemain) : that.frozenRemain != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recipeId;
        result = 31 * result + (shopId != null ? shopId.hashCode() : 0);
        result = 31 * result + (recipeName != null ? recipeName.hashCode() : 0);
        result = 31 * result + (recipePrice != null ? recipePrice.hashCode() : 0);
        result = 31 * result + (monthlySale != null ? monthlySale.hashCode() : 0);
        result = 31 * result + (recipeIntroduction != null ? recipeIntroduction.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(recipeImage);
        result = 31 * result + (recipeRemain != null ? recipeRemain.hashCode() : 0);
        result = 31 * result + (recipeDiscount != null ? recipeDiscount.hashCode() : 0);
        result = 31 * result + (recipeStatus != null ? recipeStatus.hashCode() : 0);
        result = 31 * result + (frozenRemain != null ? frozenRemain.hashCode() : 0);
        return result;
    }

}
