package com.example.api.service;

import com.example.api.form.Recipe;

import java.util.List;

public interface SmRecipeService {
    List<Recipe> findAllByShopId(int shopId);

    int updateRecipe(int recipeId, String recipeName,
                      Double recipePrice, String recipeIntroduction,
                      Double recipeDiscount, int recipeRemain);

    List<Recipe> findTop5ByShopId(int shopId);

}
