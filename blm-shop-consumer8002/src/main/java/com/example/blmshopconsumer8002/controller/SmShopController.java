package com.example.blmshopconsumer8002.controller;

import com.alibaba.fastjson.JSONObject;

import com.example.api.form.Shop;
import com.example.api.form.ShopForm;
import com.example.api.service.SmShopService;
import com.example.api.util.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin
@RequestMapping("/shop")
@Api(value = "商家接口")
@Slf4j
public class SmShopController {
    @Reference
    private SmShopService service;

    @GetMapping("/findAll")
    @ApiOperation("获得所有商家的信息")
    public ListJsonObject findAll() {
        List<Shop> res_lst = service.findAll();
        ListJsonObject res = new ListJsonObject();
        res.setStatusObject(StatusHouse.COMMON_STATUS_OK);
        res.setData(res_lst);
        return res;
    }

    @GetMapping("/findByShopId")
    @ApiOperation("根据shopId获取商家信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shopId", value = "商家序号"),
    })
    public JsonObject<Shop> findByShopId(@RequestParam int shopId) {
        JsonObject<Shop> res = new JsonObject<>();
        res.setStatusObject(StatusHouse.COMMON_STATUS_OK);
        res.setData(service.findByShopId(shopId));
        return res;
    }

    @GetMapping("/login")
    @ApiOperation("通过手机号和密码登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shopTel", value = "商家联系电话"),
            @ApiImplicitParam(name = "shopPwd", value = "商家登录密码")
    })
    public AbstractJsonObject login(@RequestParam String shopTel, @RequestParam String shopPwd, @RequestParam String token) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("shopTel", shopTel);
        jsonObject.put("shopPwd", shopPwd);
        if (Md5Util.getToken(jsonObject, token)) {
            return service.findByShopTelAndShopPwd(shopTel, shopPwd);
        } else {
            AbstractJsonObject res = new AbstractJsonObject();
            res.setStatusObject(StatusHouse.COMMON_STATUS_TOKENERROR);
            return res;
        }
    }

    @GetMapping("/logout")
    @ApiOperation("商家登出操作,同时修改数据库状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shopId", value = "商家id"),
    })
    public AbstractJsonObject logout(@RequestParam int shopId, @RequestParam String token) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("shopId", shopId);
        if (Md5Util.getToken(jsonObject, token)) {
            AbstractJsonObject res = new AbstractJsonObject();
            res.setStatusObject(StatusHouse.COMMON_STATUS_OK);
            return res;
        } else {
            AbstractJsonObject res = new AbstractJsonObject();
            res.setStatusObject(StatusHouse.COMMON_STATUS_TOKENERROR);
            return res;
        }

    }

    @PostMapping("/modifyShopInfo")
    @ApiOperation("修改商家部分信息:店铺名称、地点、电话和公告")
    public AbstractJsonObject modifyShopInfo(@RequestBody ShopForm form) {
        service.updateShopInf(form);
        AbstractJsonObject res = new AbstractJsonObject();
        res.setStatusObject(StatusHouse.COMMON_STATUS_OK);
        return res;
    }

    @GetMapping("/modifyPwd")
    @ApiOperation("修改商家密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shopId", value = "商家id"),
            @ApiImplicitParam(name = "shopPwd", value = "密码")
    })
    public AbstractJsonObject modifyPwd(@RequestParam int shopId, @RequestParam String shopPwd, @RequestParam String token) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("shopId", shopId);
        jsonObject.put("shopPwd", shopPwd);
        if (Md5Util.getToken(jsonObject, token)) {
            service.updateShopPwd(shopId, shopPwd);
            AbstractJsonObject res = new AbstractJsonObject();
            res.setStatusObject(StatusHouse.COMMON_STATUS_OK);
            return res;
        } else {
            AbstractJsonObject res = new AbstractJsonObject();
            res.setStatusObject(StatusHouse.COMMON_STATUS_TOKENERROR);
            return res;
        }

    }

}
