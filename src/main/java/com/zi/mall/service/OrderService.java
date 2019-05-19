/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: OrderService
 * Author: Zi
 * Date: 2019/4/18 15:42
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
package com.zi.mall.service;

import com.zi.mall.domain.Order;
import com.zi.mall.model.LayuiTableModel;
import com.zi.mall.vo.DataAndView;
import com.zi.mall.vo.OrderVo;
import com.zi.mall.vo.PayVo;

/**
 * 〈〉
 * @author Zi
 * @create 2019/4/18
 * @since 1.0.0
 */
public interface OrderService {
    DataAndView getOrderList(Integer page, Integer limit, Integer userId);

    /**
     * 添加订单
     * @param orderVo
     * @return 返回订单
     */
    PayVo addOrder(OrderVo orderVo);
    /**
     * 修改订单交易单号
     */
    void updateOrderOddno(Order order);
    /**
     * 查询订单状态
     */
    Order queryOrderStart(String orderid);

    LayuiTableModel<OrderVo> queryAll(OrderVo orderVo);

    void ship(Order order);

    void updateOrderStart(String out_trade_no);
}