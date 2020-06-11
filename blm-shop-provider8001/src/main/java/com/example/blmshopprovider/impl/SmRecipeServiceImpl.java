package com.example.blmshopprovider.impl;

import com.example.api.entity.SmRecipeEntity;
import com.example.api.form.Recipe;
import com.example.api.form.RecipeUser;
import com.example.api.service.SmRecipeService;
import com.example.blmshopprovider.dao.mapper.SmRecipeMapper;
import com.example.blmshopprovider.dao.mapper2.SmRecipeMapper2;
import com.github.pagehelper.PageHelper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class SmRecipeServiceImpl implements SmRecipeService {
    @Resource
    private SmRecipeMapper mapper;
    @Resource
    private SmRecipeMapper2 mapper2;

    @Override
    public List<Recipe> findAllByShopId(int shopId,int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(SmRecipeEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("shopId", shopId);
        List<SmRecipeEntity> entities = mapper2.selectByExample(example);
        List<Recipe> recipes = new ArrayList<>();
        for (SmRecipeEntity entity : entities) {
            Recipe recipe = new Recipe();
            BeanUtils.copyProperties(entity, recipe);
            recipes.add(recipe);
        }
        return recipes;
    }

    @Override
    public int updateRecipe(int recipeId, String recipeName,
                            Double recipePrice, String recipeIntroduction,
                            Double recipeDiscount, int recipeRemain) {
        Example example = new Example(SmRecipeEntity.class);
        Example.Criteria criteria = example.createCriteria();
        SmRecipeEntity entity = new SmRecipeEntity();
        entity.setRecipeName(recipeName);
        entity.setRecipeIntroduction(recipeIntroduction);
        entity.setRecipePrice(recipePrice);
        entity.setRecipeDiscount(recipeDiscount);
        entity.setRecipeRemain(recipeRemain);
        criteria.andEqualTo("recipeId", recipeId);
        return mapper.updateByExampleSelective(entity, example);
    }

    @Override
    public List<Recipe> findTop5ByShopId(int shopId) {
        return mapper2.getMax5Recipe(shopId);
    }

    @Override
    public List<RecipeUser> getRecipeByShopIdUser(int shopId) {
        return mapper2.getRecipeByShopIdUser(shopId);
    }

    @Override
    public int addRecipe(SmRecipeEntity entity) {
        return mapper.insert(entity);
    }

}
