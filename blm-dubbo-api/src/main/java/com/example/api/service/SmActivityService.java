package com.example.api.service;

import com.example.api.form.Activity;

import java.util.List;

public interface SmActivityService {

    List<Activity> findAllByShopId(int shopId);

    void updateActivityStatus();
}
