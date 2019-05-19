/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: OrderServiceImpl
 * Author: Zi
 * Date: 2019/4/18 15:43
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zi.mall.domain.Goods;
import com.zi.mall.domain.Order;
import com.zi.mall.domain.OrderExample;
import com.zi.mall.domain.User;
import com.zi.mall.mapper.GoodsMapper;
import com.zi.mall.mapper.OrderMapper;
import com.zi.mall.mapper.UserMapper;
import com.zi.mall.model.LayuiTableModel;
import com.zi.mall.service.OrderService;
import com.zi.mall.utils.RandomUtils;
import com.zi.mall.vo.DataAndView;
import com.zi.mall.vo.GoodsVo;
import com.zi.mall.vo.OrderVo;
import com.zi.mall.vo.PayVo;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Zi
 * @create 2019/4/18
 * @since 1.0.0
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper mapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public DataAndView getOrderList(Integer page, Integer limit, Integer userId) {
        Page<Object> objects = PageHelper.startPage(page, limit);
        OrderExample example = new OrderExample();
        example.createCriteria().andUserIdEqualTo(userId);
        example.setOrderByClause("timestamp desc");
        List<Order> orders = mapper.selectByExample(example);
        return new DataAndView(objects.getTotal(), orders);
    }

    @Override
    public PayVo addOrder(OrderVo orderVo) {
        //设置订单id
        orderVo.setOrderid(RandomUtils.randomOrderId());
        //设置商品信息（选一个）
        GoodsVo goodsVo = orderVo.getGoodslist().get(0);
        Goods goods = goodsMapper.selectByPrimaryKey(goodsVo.getId());
        //小计
        orderVo.setPrice(goodsVo.getTotalPrice());
        orderVo.setGoodsId(goodsVo.getId());
        orderVo.setAvatar(goods.getGoodsImg());
        orderVo.setTimestamp(new Date());
        //待支付状态
        orderVo.setState("4");
        orderVo.setNumber(goodsVo.getNumber());
        mapper.insertSelective(orderVo);
        //插入订单商品
        List<GoodsVo> goodslist = orderVo.getGoodslist();
        for (GoodsVo vo : goodslist) {
            mapper.insertOrderGoods(orderVo.getOrderid(), vo.getId());
        }
        return new PayVo(orderVo.getOrderid(), "居家商城-" + goods.getGoodsName(), orderVo.getPrice().toString(), goods.getGoodsName());
    }

    @Override
    public void updateOrderOddno(Order order) {
        mapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public Order queryOrderStart(String orderid) {
        return mapper.selectByPrimaryKey(orderid);
    }

    @Override
    public LayuiTableModel<OrderVo> queryAll(OrderVo orderVo) {
        Page<Object> objects = PageHelper.startPage(orderVo.getPage(), orderVo.getLimit());
        List<Order> orders = mapper.selectOrder(orderVo);
        ArrayList<OrderVo> orderVos = new ArrayList<>();
        for (Order order : orders) {
            User user = userMapper.selectByPrimaryKey(order.getUserId());
            OrderVo orderVo1 = new OrderVo();
            BeanUtils.copyProperties(order, orderVo1);
            orderVo1.setUserName(user.getUserName());
            orderVos.add(orderVo1);
        }
        return new LayuiTableModel<>(0, "", objects.getTotal(), orderVos);
    }

    @Override
    public void ship(Order order) {
        mapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public void updateOrderStart(String out_trade_no) {
        Order order = new Order();
        order.setOrderid(out_trade_no);
        order.setState("0");
        mapper.updateByPrimaryKeySelective(order);
    }
}
