package com.example.blmshopconsumer8002.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.api.service.SmActivityService;
import com.example.api.util.AbstractJsonObject;
import com.example.api.util.ListJsonObject;
import com.example.api.util.Md5Util;
import com.example.api.util.StatusHouse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/activity")
@Api(value = "商家活动接口")
public class SmActivityController {
    @Reference
    private SmActivityService service;

    @GetMapping("/getActivitiesByShopId")
    @ApiOperation("通过shopId获得相应活动")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shopId", value = "商家id")
    })
    public AbstractJsonObject getActivitiesByShopId(@RequestParam int shopId, @RequestParam String token) {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("shopId",shopId);
        if(Md5Util.getToken(jsonObject,token)){
            ListJsonObject result=new ListJsonObject();
            result.setStatusObject(StatusHouse.COMMON_STATUS_OK);
            result.setData(service.findAllByShopId(shopId));
            return result;
        }else{
            AbstractJsonObject res=new AbstractJsonObject();
            res.setStatusObject(StatusHouse.COMMON_STATUS_TOKENERROR);
            return res;
        }

    }

}
