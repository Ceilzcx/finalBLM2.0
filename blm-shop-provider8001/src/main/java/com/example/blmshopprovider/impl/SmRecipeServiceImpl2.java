package com.example.blmshopprovider.impl;

import com.example.api.entity.SmRecipeEntity;
import com.example.api.form.Recipe;
import com.example.api.service.SmRecipeServiceTransactional;
import com.example.blmshopprovider.dao.mapper.SmRecipeMapper;
import com.example.blmshopprovider.dao.mapper2.SmRecipeMapper2;
import org.apache.dubbo.config.annotation.Service;
import org.mengyun.tcctransaction.api.Compensable;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class SmRecipeServiceImpl2 implements SmRecipeServiceTransactional {
    @Resource
    private SmRecipeMapper mapper;
    @Resource
    private SmRecipeMapper2 mapper2;

    @Override
    public List<Recipe> findAllByShopId(int shopId) {
        Example example = new Example(SmRecipeEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("shopId", shopId);
        List<SmRecipeEntity> entities = mapper.selectByExample(example);
        List<Recipe> recipes = new ArrayList<>();
        for (SmRecipeEntity entity : entities) {
            Recipe recipe = new Recipe();
            BeanUtils.copyProperties(entity, recipe);
            recipes.add(recipe);
        }
        return recipes;
    }

    @Override
    public void updateRecipe(int recipeId, String recipeName,
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
        mapper.updateByExampleSelective(entity, example);
    }

    @Override
    public List<Recipe> findTop5ByShopId(int shopId) {
        return mapper2.getMax5Recipe(shopId);
    }

    @Override
    @Compensable(confirmMethod = "confirmUpdateRecipeRemain", cancelMethod = "cancelUpdateRecipeRemain", asyncConfirm = true)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { RuntimeException.class })
    public void updateRecipeRemain(int recipeId, int recipeNum) {
        Recipe recipe = mapper2.findByRecipeId(recipeId).get(0);
        SmRecipeEntity example = new SmRecipeEntity();
        example.setRecipeId(recipeId);
        System.out.println(example.getRecipeId());
        SmRecipeEntity entity = mapper2.select(example).get(0);
        System.out.println(recipeNum);
        System.out.println(recipe.getRecipeRemain());
        if (recipe.getRecipeRemain() < recipeNum) throw new RuntimeException("余量不足");
        if (entity.getFrozenRemain() != 0) throw new RuntimeException("数据被冻结");
        mapper.updateRecipeFrozenRemain(recipeId, recipeNum);
    }

    @Override
    @Transactional
    public void confirmUpdateRecipeRemain(int recipeId, int recipeNum) {
        System.out.println("confirm");
        mapper.updateRecipeFrozenRemain(recipeId, 0);
        mapper.updateRecipeRemain(recipeId, recipeNum);
    }

    @Override
    @Transactional
    public void cancelUpdateRecipeRemain(int recipeId, int recipeNum) {
        System.out.println("cancel");
        mapper.updateRecipeFrozenRemain(recipeId, 0);
    }


    @Override
    public Recipe findByRecipeId(int recipeId) {
        return mapper2.findByRecipeId(recipeId).get(0);
    }



}
