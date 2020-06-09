package com.example.blmshopprovider.dao.mapper;

import com.example.api.entity.SmShopEntity;
import com.example.api.form.ShopEva;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SmShopEvaMapper extends Mapper<SmShopEntity> {

    @Select({"select eva.user_id, u.user_name, u.user_image, eva.evaluate_id, eva.evaluate_content, eva.evaluate_image, eva.evaluate_rating" +
            " from sm_shop_evaluate eva left outer join um_user u on eva.user_id = u.user_id where eva.shop_id=#{shopId}"})
    @Results({@Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userImage", column = "user_image"),
            @Result(property = "shopEvaId", column = "evaluate_id"),
            @Result(property = "content", column = "evaluate_content"),
            @Result(property = "shopEvaImage", column = "evaluate_image"),
            @Result(property = "shopEvaRating", column = "evaluate_rating")})
    List<ShopEva> getShopEva(int shopId);

}
