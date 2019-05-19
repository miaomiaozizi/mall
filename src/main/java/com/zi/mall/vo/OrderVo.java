/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: OrderVo
 * Author: Zi
 * Date: 2019/4/29 15:59
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.vo;

import com.zi.mall.domain.Order;
import com.zi.mall.domain.User;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author Zi
 * @create 2019/4/29
 * @since 1.0.0
 */
public class OrderVo extends Order {
    private List<GoodsVo> goodslist;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date engDate;
    private Integer page;
    private Integer limit;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEngDate() {
        return engDate;
    }

    public void setEngDate(Date engDate) {
        this.engDate = engDate;
    }

    public List<GoodsVo> getGoodslist() {
        return goodslist;
    }

    public void setGoodslist(List<GoodsVo> goodslist) {
        this.goodslist = goodslist;
    }
}
