package com.example.blmuserconsumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.api.entity.UmUserEntity;
import com.example.api.form.User;
import com.example.api.service.UmUserService;
import com.example.api.util.AbstractJsonObject;
import com.example.api.util.Md5Util;
import com.example.api.util.SingleObject;
import com.example.api.util.StatusHouse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
@Api(value = "用户接口")
public class UmUserController {
    @Reference
    private UmUserService service;

    @GetMapping("/login")
    @ApiOperation("通过账号密码登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userAccount", value = "用户登录账号"),
            @ApiImplicitParam(name = "userPwd", value = "密码")
    })
    public AbstractJsonObject login(@RequestParam(value = "userAccount") String userAccount,
                                    @RequestParam(value = "userPwd") String userPwd,
                                    @RequestParam(value = "token") String token){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("userAccount",userAccount);
        jsonObject.put("userPwd",userPwd);
        if(Md5Util.getToken(jsonObject,token)){
            List<UmUserEntity> entities = service.select(userAccount,userPwd);
            if(entities.size() == 0)
            {
                AbstractJsonObject res=new AbstractJsonObject();
                res.setStatusObject(StatusHouse.COMMON_STATUS_NORECORD);
                return res;
            }
            else if (entities.size() == 1) {
                User user = new User();
                BeanUtils.copyProperties(entities.get(0), user);
                SingleObject res=new SingleObject();
                res.setStatusObject(StatusHouse.COMMON_STATUS_OK);
                res.setData(user);
                return res;
            }
            else{
                System.out.println("exist same username");
                return null;
            }
        }else {
            AbstractJsonObject res=new AbstractJsonObject();
            res.setStatusObject(StatusHouse.COMMON_STATUS_TOKENERROR);
            return res;
        }

    }
}
