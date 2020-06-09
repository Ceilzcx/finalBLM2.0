package com.example.blmshopprovider.impl;

import com.example.api.entity.SmShopEntity;
import com.example.api.form.Shop;
import com.example.api.form.ShopForm;
import com.example.api.service.SmShopService;
import com.example.api.util.AbstractJsonObject;
import com.example.api.util.SingleObject;
import com.example.api.util.StatusHouse;
import com.example.blmshopprovider.dao.mapper.SmShopMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class SmShopServiceImpl implements SmShopService {
    @Resource
    private SmShopMapper mapper;

    @Override
    public List<Shop> findAll() {
        List<SmShopEntity> lst = mapper.selectAll();
        List<Shop> res_lst = new ArrayList<>();
        for (SmShopEntity s : lst) {
            Shop r = new Shop();
            BeanUtils.copyProperties(s, r);
            res_lst.add(r);
        }
        return res_lst;
    }

    @Override
    public Shop findByShopId(int shopId) {
        return mapper.getShopByShopId(shopId);
    }

    @Override
    public AbstractJsonObject findByShopTelAndShopPwd(String shopTel, String shopPwd) {
        SmShopEntity entity = new SmShopEntity();
        entity.setShopTel(shopTel);
        entity.setShopPwd(shopPwd);
        List<SmShopEntity> entities = mapper.select(entity);
        if (entities.size() == 0) {
            AbstractJsonObject res = new AbstractJsonObject();
            res.setStatusObject(StatusHouse.COMMON_STATUS_NORECORD);
            return res;
        } else if (entities.size() == 1) {
            SingleObject res = new SingleObject();
            res.setStatusObject(StatusHouse.COMMON_STATUS_OK);
            Shop shop = new Shop();
            SmShopEntity resEntity = entities.get(0);
            SmShopEntity modifyEntity = new SmShopEntity();
            modifyEntity.setShopId(resEntity.getShopId());
            modifyEntity.setShopLogintime(new Timestamp(System.currentTimeMillis()));
            Example example = new Example(SmShopEntity.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("shopId", modifyEntity.getShopId());
            mapper.updateByExampleSelective(modifyEntity, example);
            BeanUtils.copyProperties(resEntity, shop);
            res.setData(shop);
            return res;
        } else {
            return null;
        }
    }

    @Override
    public int updateShopInf(ShopForm form) {
        SmShopEntity entity = new SmShopEntity();
        BeanUtils.copyProperties(form, entity);
        Example example = new Example(SmShopEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("shopId", entity.getShopId());
        return mapper.updateByExampleSelective(entity, example);
    }

    @Override
    public int updateShopPwd(int shopId, String shopPwd) {
        SmShopEntity entity = new SmShopEntity();
        entity.setShopId(shopId);
        entity.setShopPwd(shopPwd);
        Example example = new Example(SmShopEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("shopId", entity.getShopId());
        return mapper.updateByExampleSelective(entity, example);
    }

    @Override
    public int modifyShopState(int shopId, String state) {
        SmShopEntity entity = new SmShopEntity();
        entity.setShopId(shopId);
        entity.setShopStatus(state);
        Example example = new Example(SmShopEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("shopId", entity.getShopId());
        return mapper.updateByExampleSelective(entity, example);
    }

}
