package com.example.api.form;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RecipeUser implements Serializable {
    private int recipeId;
    private String recipeName;
    private Double recipePrice;
    private Integer monthlySale;
    private String recipeIntroduction;
    private Integer recipeRemain;
    private Double recipeDiscount;
    private String recipeStatus;

    public byte[] getRecipeImage() {
        return recipeImage;
    }

    public void setRecipeImage(byte[] recipeImage) {
        this.recipeImage = recipeImage;
    }

    private byte[] recipeImage;
}
