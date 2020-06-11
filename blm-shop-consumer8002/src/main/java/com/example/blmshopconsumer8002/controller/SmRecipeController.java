package com.example.blmshopconsumer8002.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.api.entity.SmRecipeEntity;
import com.example.api.form.Recipe;
import com.example.api.form.RecipeUser;
import com.example.api.service.SmRecipeService;
import com.example.api.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/recipe")
@Api("菜单接口")
public class SmRecipeController {
    @Reference
    private SmRecipeService service;

    @GetMapping("/getRecipeList")
    @ApiOperation("通过商家id获得菜单的列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shopId", value = "商家id"),
            @ApiImplicitParam(name = "pageNum", value = "页号"),
            @ApiImplicitParam(name = "pageSize", value = "页面大小"),
    })
    public AbstractJsonObject getRecipeList(@RequestParam int shopId, @RequestParam int pageNum, @RequestParam int pageSize, @RequestParam String token) {
        PageHelper.startPage(pageNum, pageSize);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("shopId",shopId);
        jsonObject.put("pageNum", pageNum);
        jsonObject.put("pageSize", pageSize);
        if(Md5Util.getToken(jsonObject,token)){
            PageJsonObject res=new PageJsonObject();
            res.setStatusObject(StatusHouse.COMMON_STATUS_OK);
            List<Recipe> recipes = service.findAllByShopId(shopId);
            PageInfo<Recipe> info = new PageInfo<>(recipes);
            res.setInfo(info);
            return res;
        } else {
            AbstractJsonObject res = new AbstractJsonObject();
            res.setStatusObject(StatusHouse.COMMON_STATUS_TOKENERROR);
            return res;
        }

    }

    @GetMapping("/getAllRecipeList")
    @ApiOperation("通过商家id获得菜单的列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shopId", value = "商家id"),
    })
    public AbstractJsonObject getAllRecipeList(@RequestParam int shopId) {
        ListJsonObject res = new ListJsonObject();
        res.setStatusObject(StatusHouse.COMMON_STATUS_OK);
        List<Recipe> recipes = service.findAllByShopId(shopId);
        res.setData(recipes);
        return res;
    }

    @GetMapping("/getAllRecipeListWithoutIMG")
    @ApiOperation("通过商家id获得菜单的列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shopId", value = "商家id"),
    })
    public AbstractJsonObject getAllRecipeListWithoutIMG(@RequestParam int shopId) {
        ListJsonObject res = new ListJsonObject();
        res.setStatusObject(StatusHouse.COMMON_STATUS_OK);
        List<Recipe> recipes = service.findAllByShopId(shopId);
        for (Recipe recipe : recipes) {
            recipe.setRecipeImage(null);
        }
        res.setData(recipes);
        return res;
    }

    @GetMapping("/modifyRecipe")
    @ApiOperation("修改菜谱")
    public AbstractJsonObject modifyRecipe(@RequestParam int recipeId, @RequestParam String recipeName,
                                           @RequestParam Double recipePrice, @RequestParam String recipeIntroduction,
                                           @RequestParam Double recipeDiscount, @RequestParam int recipeRemain) {
        AbstractJsonObject res = new AbstractJsonObject();
        int result = service.updateRecipe(recipeId, recipeName, recipePrice, recipeIntroduction,
                    recipeDiscount, recipeRemain);
        if (result != 0)
            res.setStatusObject(StatusHouse.COMMON_STATUS_OK);
        else
            res.setStatusObject(StatusHouse.COMMON_STATUS_DBERROR);
        return res;
    }

    @GetMapping("/getMax5Recipe")
    @ApiOperation("通过商家id获得前5月销量的菜品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shopId", value = "商家id")
    })
    public AbstractJsonObject getRecipeList(@RequestParam int shopId) {
        List<Recipe> recipes = service.findTop5ByShopId(shopId);
        ListJsonObject res = new ListJsonObject();
        res.setStatusObject(StatusHouse.COMMON_STATUS_OK);
        res.setData(recipes);
        return res;
    }

    @GetMapping("/getRecipeByShopIdUser")
    @ApiOperation("用户端:通过商家id获得所有的菜品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shopId", value = "商家id")
    })
    public AbstractJsonObject getRecipesByShopIdUser(@RequestParam int shopId) {
        List<RecipeUser> recipes = service.getRecipeByShopIdUser(shopId);
        ListJsonObject res = new ListJsonObject();
        res.setStatusObject(StatusHouse.COMMON_STATUS_OK);
        res.setData(recipes);
        return res;
    }

    @PostMapping("/addRecipe")
    public AbstractJsonObject addRecipe(HttpServletRequest request){
        AbstractJsonObject object = new AbstractJsonObject();
        MultipartHttpServletRequest params = (MultipartHttpServletRequest) request;
        List<MultipartFile> files = params.getFiles("recipeImage");
        MultipartFile recipeImage = null;
        if(files.size() != 0)
            recipeImage = files.get(0);
        try {
            String recipeName = params.getParameter("recipeName");
            Integer shopId = Integer.parseInt(params.getParameter("shopId").trim());
            Double recipePrice = Double.parseDouble(params.getParameter("recipePrice").trim());
            Integer recipeRemain = Integer.parseInt(params.getParameter("recipeRemain").trim());
            String recipeIntroduction = params.getParameter("recipeIntroduction");
            SmRecipeEntity entity = new SmRecipeEntity();
            entity.setMonthlySale(0);
            entity.setRecipeDiscount(1.0);
            entity.setShopId(shopId);
            entity.setRecipeImage(recipeImage.getBytes());
            entity.setRecipeIntroduction(recipeIntroduction);
            entity.setRecipePrice(recipePrice);
            entity.setRecipeRemain(recipeRemain);
            entity.setRecipeName(recipeName);
            entity.setRecipeStatus("正常");
            int result = service.addRecipe(entity);
            if (result != 0)
                object.setStatusObject(StatusHouse.COMMON_STATUS_OK);
            else
                object.setStatusObject(StatusHouse.COMMON_STATUS_DBERROR);
            return object;
        } catch (NumberFormatException | NullPointerException | IOException e){
            e.printStackTrace();
            object.setCode(0);
            object.setMsg("添加内容缺失或格式错误");
            return object;
        }
    }

}
