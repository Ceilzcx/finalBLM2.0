package com.example.blmshopconsumer8002.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.api.service.SmShopEvaService;
import com.example.api.util.AbstractJsonObject;
import com.example.api.util.ListJsonObject;
import com.example.api.util.Md5Util;
import com.example.api.util.StatusHouse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shopEva")
@CrossOrigin
@Api("店铺评论接口")
public class SmShopEvaController {
    @Reference
    private SmShopEvaService mapper;

    @GetMapping("/getShopEva")
    @ApiOperation("返回用户评论的列表，包括用户id、用户名、头像、评论id、评论内容、评论的图片、评分")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shopId", value = "商家id")
    })
    public AbstractJsonObject getShopEva(@RequestParam int shopId, @RequestParam String token){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("shopId",shopId);
        if(Md5Util.getToken(jsonObject,token)){
            ListJsonObject res=new ListJsonObject();
            res.setStatusObject(StatusHouse.COMMON_STATUS_OK);
            res.setData(mapper.findAllByShopId(shopId));
            return res;
        }else{
            AbstractJsonObject res=new AbstractJsonObject();
            res.setStatusObject(StatusHouse.COMMON_STATUS_TOKENERROR);
            return res;
        }

    }
}
