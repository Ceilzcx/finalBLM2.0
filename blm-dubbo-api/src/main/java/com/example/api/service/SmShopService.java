package com.example.api.service;

import com.example.api.form.Shop;
import com.example.api.form.ShopForm;
import com.example.api.util.AbstractJsonObject;

import java.util.List;

public interface SmShopService {
    List<Shop> findAll();

    Shop findByShopId(int shopId);

    AbstractJsonObject findByShopTelAndShopPwd(String shopTel, String shopPwd);

    int updateShopInf(ShopForm form);

    int updateShopPwd(int shopId, String shopPwd);

    int modifyShopState(int shopId, String state);

}
