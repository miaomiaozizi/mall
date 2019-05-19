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

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zi.mall.domain.Goods;
import com.zi.mall.domain.GoodsAttribute;
import com.zi.mall.domain.GoodsDetailsExample;
import com.zi.mall.domain.GoodsExample;
import com.zi.mall.domain.GoodsImgExample;
import com.zi.mall.mapper.GoodsDetailsMapper;
import com.zi.mall.mapper.GoodsImgMapper;
import com.zi.mall.mapper.GoodsMapper;
import com.zi.mall.model.LayuiTableModel;
import com.zi.mall.service.GoodsAttrService;
import com.zi.mall.service.GoodsService;
import com.zi.mall.vo.GoodsVo;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ch.qos.logback.core.net.SyslogOutputStream;

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
    @Autowired
    private GoodsDetailsMapper detailsMapper;
    @Autowired
    private GoodsImgMapper imgMapper;
    @Autowired
    private GoodsAttrService goodsAttrService;

    @Override
    public List<Goods> getHotGoods(Integer sum) {
        return goodsMapper.selectHotGoods(sum);
    }

    @Override
    public List<Goods> getNewGoods(Integer sum) {
        return this.goodsMapper.selectNewGoods(sum);
    }

    @Override
    public GoodsVo queryGoods(Integer id) {
        //查询商品常用属性
        Goods goods = goodsMapper.selectByPrimaryKey(id);
        List<GoodsAttribute> goodsAttributes = goodsAttrService.queryGoodsAttr(id);
        GoodsVo goodsVo = new GoodsVo();
        Map<String, List<String>> goodsAttrMap = new HashMap<>(2);
        for (int i = 0; i < goodsAttributes.size(); i++) {
            ArrayList<String> strings = new ArrayList<>();
            strings.add(goodsAttributes.get(i).getAttrValue());
            for (int j = i + 1; j < goodsAttributes.size(); j++) {
                if (goodsAttributes.get(i).getId().equals(goodsAttributes.get(j).getId())) {
                    strings.add(goodsAttributes.get(j).getAttrValue());
                }
            }
            if (!goodsAttrMap.containsKey(goodsAttributes.get(i).getAttrName())) {
                goodsAttrMap.put(goodsAttributes.get(i).getAttrName(), strings);
            }
        }

        BeanUtils.copyProperties(goods, goodsVo);
        goodsVo.setGoodsAttr(goodsAttrMap);
        return goodsVo;
    }

    @Override
    public List<Goods> queryGoodsByCatId(Integer page, Integer pageSize, Integer catId) {
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andCatIdEqualTo(catId);
        PageHelper.startPage(page, pageSize);
        List<Goods> goods = goodsMapper.selectByExample(goodsExample);
        return goods;
    }

    @Override
    public LayuiTableModel<GoodsVo> queryGoods(GoodsVo goodsVo) {
        Page<Object> objects = PageHelper.startPage(goodsVo.getPage(), goodsVo.getLimit());
        List<GoodsVo> goods = goodsMapper.selectGoodsList(goodsVo);
        return new LayuiTableModel<>(0, "", objects.getTotal(), goods);
    }

    @Override
    public void addGoods(Goods goods) {
        goods.setCreateTime(new Date());
        goods.setUpdateTime(new Date());
        goodsMapper.insertSelective(goods);
        detailsMapper.updateGoodsId(goods.getId());
        imgMapper.updateGoodsId(goods.getId());
    }

    @Override
    public void deleteGoods(Integer goodsId) {
        goodsMapper.deleteByPrimaryKey(goodsId);
        GoodsDetailsExample detailsExample = new GoodsDetailsExample();
        GoodsDetailsExample.Criteria criteria = detailsExample.createCriteria();
        criteria.andGoodsIdEqualTo(goodsId);
        detailsMapper.deleteByExample(detailsExample);
        GoodsImgExample goodsImgExample = new GoodsImgExample();
        GoodsImgExample.Criteria criteria1 = goodsImgExample.createCriteria();
        criteria1.andGoodsIdEqualTo(goodsId);
        imgMapper.deleteByExample(goodsImgExample);
    }

    @Override
    public void updateGoods(Goods goods) {
        goodsMapper.updateByPrimaryKeySelective(goods);
    }

    @Override
    public List<Goods> queryByIdList(List<Integer> ids) {
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andIdIn(ids);
        List<Goods> goods = goodsMapper.selectByExample(goodsExample);
        System.out.println(goods);
        return goods;

    }

    @Override
    public List<Goods> queryGoodsByGoodsName(int page, int pageSize, String goodsName) {

        return null;
    }
}
