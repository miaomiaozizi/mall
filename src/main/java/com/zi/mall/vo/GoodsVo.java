/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: GoodsVo
 * Author: Zi
 * Date: 2019/4/12 15:59
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.vo;

import com.zi.mall.domain.Goods;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author Zi
 * @create 2019/4/12
 * @since 1.0.0
 */
public class GoodsVo extends Goods {
    private Map<String,List<String>> goodsAttr;
    private String catName;
    private List<String> goodsImgs;
    private Integer page;
    private Integer limit;
    /**
     *   商品数量
     */
    private Integer number;
    private BigDecimal totalPrice;


    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
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

    public List<String> getGoodsImgs() {
        return goodsImgs;
    }

    public void setGoodsImgs(List<String> goodsImgs) {
        this.goodsImgs = goodsImgs;
    }

    public Map<String, List<String>> getGoodsAttr() {
        return goodsAttr;
    }

    public void setGoodsAttr(Map<String, List<String>> goodsAttr) {
        this.goodsAttr = goodsAttr;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
