package com.example.blmorderprovider8003.dao.mapper;

import com.example.api.entity.OmOrderEntity;
import com.example.api.form.Order;
import com.example.api.form.OrderApp;
import com.example.api.form.OrderInfAllApp;
import com.example.api.form.ShopOrder;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface OmOrderMapper extends Mapper<OmOrderEntity> {

}
