package com.example.api.service;

import com.example.api.form.ShopEva;

import java.util.List;

public interface SmShopEvaService {
    List<ShopEva> findAllByShopId(int shopId);
}
