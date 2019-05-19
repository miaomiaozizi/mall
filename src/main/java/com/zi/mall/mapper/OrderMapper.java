package com.zi.mall.mapper;

import com.zi.mall.domain.Order;
import com.zi.mall.domain.OrderExample;
import com.zi.mall.vo.OrderVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(String orderid);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(String orderid);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    /**
     * 订单对应的商品表插入
     */
    int insertOrderGoods(String orderId,Integer goodsId);

    List<Order> selectOrder(OrderVo orderVo);
}