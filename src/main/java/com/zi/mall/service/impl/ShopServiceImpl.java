/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: ShopServiceImpl
 * Author: Zi
 * Date: 2019/4/30 14:01
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zi.mall.domain.Goods;
import com.zi.mall.domain.Shop;
import com.zi.mall.domain.ShopExample;
import com.zi.mall.mapper.GoodsMapper;
import com.zi.mall.mapper.ShopMapper;
import com.zi.mall.model.LayuiTableModel;
import com.zi.mall.service.ShopService;
import com.zi.mall.vo.ShopVo;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author Zi
 * @create 2019/4/30
 * @since 1.0.0
 */
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopMapper shopMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public LayuiTableModel<ShopVo> queryByPage(Integer page, Integer limit, Integer userId) {
        Page<Object> objects = PageHelper.startPage(page, limit);
        ShopExample example = new ShopExample();
        example.createCriteria().andUserIdEqualTo(userId);
        //查出购物车中的商品id
        List<Shop> shops = shopMapper.selectByExample(example);
        List<ShopVo> shopVos = new ArrayList<>();
        for (Shop shop : shops) {
            Goods goods = goodsMapper.selectByPrimaryKey(shop.getGoodsId());
            ShopVo shopVo = new ShopVo( goods.getGoodsName(),"showImage?path="+goods.getGoodsImg(), "￥"+goods.getShopPrice().toString(),"￥"+goods.getMarketPrice());
            BeanUtils.copyProperties(shop,shopVo);
            shopVos.add(shopVo);
        }
        return new LayuiTableModel<>(0,"",objects.getTotal(),shopVos);
    }

    @Override
    public void addGoods(Shop shop) {
        ShopExample shopExample = new ShopExample();
        shopExample.createCriteria().andUserIdEqualTo(shop.getUserId());
        List<Shop> shops = shopMapper.selectByExample(shopExample);
        for (Shop shop1 : shops) {
            if (shop1.getGoodsId().equals(shop.getGoodsId())){
                shop1.setNumber(shop1.getNumber()+1);
                shopMapper.updateByPrimaryKeySelective(shop1);
                return;
            }
        }
        shopMapper.insertSelective(shop);
    }

    @Override
    public Integer getShopNumber(Integer id) {
        return shopMapper.selectShopNumber(id);
    }

    @Override
    public void deleteShop(Integer id) {
        shopMapper.deleteByPrimaryKey(id);
    }
}
