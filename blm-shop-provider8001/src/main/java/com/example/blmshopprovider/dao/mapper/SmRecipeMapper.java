package com.example.blmshopprovider.dao.mapper;

import com.example.api.entity.SmRecipeEntity;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

public interface SmRecipeMapper extends Mapper<SmRecipeEntity> {

    @Update("update sm_recipe set recipe_remain=recipe_remain-#{recipeNum} where recipe_id=#{recipeId}")
    void  updateRecipeRemain(int recipeId,int recipeNum);

    @Update("update sm_recipe set frozen_remain=#{recipeNum} where recipe_id=#{recipeId}")
    void  updateRecipeFrozenRemain(int recipeId,int recipeNum);

}
