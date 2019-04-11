/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: GoodsServiceImpl
 * Author: Zi
 * Date: 2019/4/8 16:50
 * Description: 商品服务实现类
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.service.impl;


import com.zi.mall.domain.Goods;
import com.zi.mall.mapper.GoodsMapper;
import com.zi.mall.service.GoodsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品服务实现类
 *
 * @author Zi
 * @create 2019/4/8
 * @since 1.0.0
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> getHotGoods(Integer sum) {
        return goodsMapper.selectHotGoods(sum);
    }

    @Override
    public List<Goods> getNewGoods(Integer sum) {
        return this.goodsMapper.selectNewGoods(sum);
    }
}
