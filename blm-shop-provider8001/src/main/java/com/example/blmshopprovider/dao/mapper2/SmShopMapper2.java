package com.example.blmshopprovider.dao.mapper2;

import com.example.api.entity.SmShopEntity;
import com.example.api.form.Shop;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface SmShopMapper2 extends Mapper<SmShopEntity> {
    @Select({"select s.shop_id, s.shop_name, s.shop_address, s.shop_tel, s.shop_rating, s.shop_notice, s.shop_trademark, s.shop_status from sm_shop s where s.shop_id=#{shop_id}"})
    @Results({@Result(property = "shopId", column = "shop_id"),
            @Result(property = "shopName", column = "shop_name"),
            @Result(property = "shopAddress", column = "shop_address"),
            @Result(property = "shopTel", column = "shop_tel"),
            @Result(property = "shopRating", column = "shop_rating"),
            @Result(property = "shopNotice", column = "shop_notice"),
            @Result(property = "shopTrademark", column = "shop_trademark"),
            @Result(property = "shopStatus", column = "shop_status")
    })
    Shop getShopByShopId(int shopId);
}
