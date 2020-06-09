package com.example.blmshopprovider.dao.mapper2;


import com.example.api.entity.SmRecipeEntity;
import com.example.api.form.Recipe;
import com.example.api.form.RecipeUser;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SmRecipeMapper2 extends Mapper<SmRecipeEntity> {

    @Select({"select s.recipe_name,s.recipe_price,s.monthly_sale,s.recipe_introduction,s.recipe_remain from sm_recipe s where s.shop_id=#{shop_id} ORDER BY s.monthly_sale DESC LIMIT 0,5"})
    @Results({@Result(property = "recipeName", column = "recipe_name"),
            @Result(property = "recipePrice", column = "recipe_price"),
            @Result(property = "monthlySale", column = "monthly_sale"),
            @Result(property = "recipeIntroduction", column = "recipe_introduction"),
            @Result(property = "recipeRemain", column = "recipe_remain")})
    List<Recipe> getMax5Recipe(int shopId);

    @Select({"select s.recipe_id,s.recipe_name,s.recipe_price,s.monthly_sale,s.recipe_introduction,s.recipe_remain,s.recipe_discount,s.recipe_status,s.recipe_image from sm_recipe s where s.shop_id=#{shop_id}"})
    @Results({
            @Result(property = "recipeId", column = "recipe_id"),
            @Result(property = "recipeName", column = "recipe_name"),
            @Result(property = "recipePrice", column = "recipe_price"),
            @Result(property = "monthlySale", column = "monthly_sale"),
            @Result(property = "recipeIntroduction", column = "recipe_introduction"),
            @Result(property = "recipeRemain", column = "recipe_remain"),
            @Result(property = "recipeDiscount", column = "recipe_discount"),
            @Result(property = "recipeStatus", column = "recipe_status"),
            @Result(property = "recipeImage", column = "recipe_image")
    })
    List<RecipeUser> getRecipeByShopIdUser(int shopId);

    @Select("select s.recipe_id,s.recipe_name,s.recipe_price,s.monthly_sale,s.recipe_introduction,s.recipe_remain,s.recipe_discount,s.recipe_status,s.recipe_image from sm_recipe s where s.recipe_id=#{recipe_id}")
    @Results({
            @Result(property = "recipeId",column = "recipe_id"),
            @Result(property = "recipePrice", column = "recipe_price"),
            @Result(property = "recipeName", column = "recipe_name"),
            @Result(property = "recipePrice", column = "recipe_price"),
            @Result(property = "monthlySale", column = "monthly_sale"),
            @Result(property = "recipeIntroduction", column = "recipe_introduction"),
            @Result(property = "recipeRemain", column = "recipe_remain")})
    List<Recipe> findByRecipeId(int recipeId);
}
