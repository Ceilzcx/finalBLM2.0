package com.example.api.form;

import com.example.api.entity.OmOrderInfEntity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderForm implements Serializable {
    Integer shopId;
    Integer userId;
    String orderRemark;
    Double orderMoney;
    Double orderReduce;
    List<OmOrderInfEntity> orderInfList;
    String userTele;
}
