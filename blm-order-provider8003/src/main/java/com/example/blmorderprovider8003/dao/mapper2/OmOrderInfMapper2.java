package com.example.blmorderprovider8003.dao.mapper2;


import com.example.api.entity.OmOrderInfEntity;
import com.example.api.form.OrderInf;
import com.example.api.form.OrderInfApp;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface OmOrderInfMapper2 extends Mapper<OmOrderInfEntity> {

    @Select("select sm_recipe.recipe_name,om_order_inf.order_recipe_number from sm_recipe,om_order_inf where sm_recipe.recipe_id=om_order_inf.recipe_id and om_order_inf.order_id=#{order_id}")
    @Results({
            @Result(property = "recipeName", column = "recipe_name"),
            @Result(property = "orderRecipeNumber", column = "order_recipe_number"),
    })
    List<OrderInf> getOrderInfName(int orderId);

    @Select("select r.recipe_name,oi.order_recipe_number,oi.order_recipe_number*r.recipe_price money from sm_recipe r,om_order_inf oi where r.recipe_id=oi.recipe_id and oi.order_id=#{orderId}")
    @Results({
            @Result(property = "recipeName", column = "recipe_name"),
            @Result(property = "orderRecipeNumber", column = "order_recipe_number"),
            @Result(property = "money", column = "money")
    })
    List<OrderInfApp> getOrderInfByOrderIdApp(int orderId);


}
