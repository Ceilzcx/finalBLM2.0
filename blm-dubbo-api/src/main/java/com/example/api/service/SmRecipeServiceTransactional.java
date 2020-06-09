package com.example.api.service;

import com.example.api.form.Recipe;

import java.util.List;

public interface SmRecipeServiceTransactional {
    List<Recipe> findAllByShopId(int shopId);

    void updateRecipe(int recipeId, String recipeName,
                      Double recipePrice, String recipeIntroduction,
                      Double recipeDiscount, int recipeRemain);

    List<Recipe> findTop5ByShopId(int shopId);

    void updateRecipeRemain(int recipeId, int recipeNum);

    void confirmUpdateRecipeRemain(int recipeId, int recipeNum);

    void cancelUpdateRecipeRemain(int recipeId, int recipeNum);

    Recipe findByRecipeId(int recipeId);


}
