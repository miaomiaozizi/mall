/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: PayVo
 * Author: Zi
 * Date: 2019/5/8 14:30
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 *
 *
 * @author Zi
 * @create 2019/5/8
 * @since 1.0.0
 */
public class PayVo implements Serializable {
    /**
     * 订单编号
     */
    @JSONField(name="out_trade_no")
    private String orderid;
    /**
     * 订单名称
     */
    @JSONField(name="subject")
    private String orderName;
    /**
     * 付款金额
     */
    @JSONField(name="total_amount")
    private String money;
    /**
     * 商品描述（可为空）
     */
    @JSONField(name="body")
    private String goodsDesc;

    public PayVo(String orderid, String orderName, String money, String goodsDesc) {
        this.orderid = orderid;
        this.orderName = orderName;
        this.money = money;
        this.goodsDesc = goodsDesc;
    }

    public PayVo() {
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }
}
