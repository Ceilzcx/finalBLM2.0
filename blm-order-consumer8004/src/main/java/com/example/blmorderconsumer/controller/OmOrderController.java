package com.example.blmorderconsumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.api.entity.OmOrderEntity;
import com.example.api.entity.OmOrderInfEntity;
import com.example.api.form.Order;
import com.example.api.form.OrderForm;
import com.example.api.form.ShopOrder;
import com.example.api.service.OmOrderInfService;
import com.example.api.service.OmOrderService;
import com.example.api.service.SmActivityService;
import com.example.api.service.UmUserService;
import com.example.api.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/order")
@Api(value = "订单接口")
@Slf4j
public class OmOrderController {
    @Reference
    private OmOrderService orderService;

    @Reference
    private OmOrderInfService orderInfService;

    @GetMapping("/getOrderListByUserId")
    @ApiOperation("获得订单信息：店铺名称、订单id、订单创建时间、订单完成时间、订单状态、备注")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id")
    })
    public AbstractJsonObject getOrderList(@RequestParam(value = "userId") int userId, @RequestParam int pageNum,
                                           @RequestParam int pageSize, @RequestParam String token) {
        PageHelper.startPage(pageNum, pageSize);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userId", userId);
        jsonObject.put("pageNum", pageNum);
        jsonObject.put("pageSize", pageSize);
        if(Md5Util.getToken(jsonObject,token)){
            PageJsonObject res=new PageJsonObject();
            res.setStatusObject(StatusHouse.COMMON_STATUS_OK);
            PageInfo<Order> info = new PageInfo<>(orderService.getOrderList(userId));
            res.setInfo(info);
            return res;
        }else{
            AbstractJsonObject res=new AbstractJsonObject();
            res.setStatusObject(StatusHouse.COMMON_STATUS_TOKENERROR);
            return res;
        }
    }

    @GetMapping("/getOrderListByShopId")
    @ApiOperation("获得订单信息：用户联系方式、订单id、订单创建时间、订单完成时间、订单状态、备注")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id")
    })
    public AbstractJsonObject getOrderListByShopId(@RequestParam int shopId, @RequestParam int pageNum, @RequestParam int pageSize, @RequestParam String token){
        PageHelper.startPage(pageNum, pageSize);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("shopId", shopId);
        jsonObject.put("pageNum", pageNum);
        jsonObject.put("pageSize", pageSize);
        if(Md5Util.getToken(jsonObject,token)){
            PageJsonObject res=new PageJsonObject();
            res.setStatusObject(StatusHouse.COMMON_STATUS_OK);
            PageInfo<ShopOrder> info = new PageInfo<>(orderService.getOrderListByShopId(shopId));
            res.setInfo(info);
            return res;
        }else{
            AbstractJsonObject res=new AbstractJsonObject();
            res.setStatusObject(StatusHouse.COMMON_STATUS_TOKENERROR);
            return res;
        }
    }

    public List<OmOrderEntity> getOrderListDone(){
        return null;
    }

    public List<OmOrderEntity> getOrderListUndo(){
        return null;
    }

    @PostMapping("/addOrderApp2")
    @ApiOperation("添加订单")
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public AbstractJsonObject addOrderApp2(@RequestBody OrderForm form) {
        try {
            SingleObject res = new SingleObject();
            res.setStatusObject(StatusHouse.COMMON_STATUS_OK);
            int orderId = orderService.insert(form);
            res.setData(orderId);
            for (OmOrderInfEntity omOrderInfEntity : form.getOrderInfList()) {
                omOrderInfEntity.setOrderId(orderId);
                log.info(omOrderInfEntity.getOrderId() + "");
                orderInfService.insert(omOrderInfEntity);
            }
            res.setData(orderId);
//            WebSocketServer.sendMessageToShop(form.getShopId(), JSONObject.toJSONString(form));
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            AbstractJsonObject res = new AbstractJsonObject();
            res.setStatusObject(StatusHouse.COMMON_STATUS_DBERROR);
            return res;
        }
    }
}
