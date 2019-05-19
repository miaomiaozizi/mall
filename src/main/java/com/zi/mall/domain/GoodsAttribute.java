package com.zi.mall.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author zi
 */
public class GoodsAttribute implements Serializable {
    /**
     * 商品属性值id
     */
    private Integer id;

    /**
     * 商品id
     */
    private Integer goodsId;

    /**
     * 商品属性id
     */
    private Integer attrId;
    /**
     * 商品属性名称
     */
    private String attrName;
    /**
     * 商品属性值
     */
    private String attrValue;

    /**
     * 商品此属性价格
     */
    private BigDecimal attrPrice;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }

    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
    }

    public BigDecimal getAttrPrice() {
        return attrPrice;
    }

    public void setAttrPrice(BigDecimal attrPrice) {
        this.attrPrice = attrPrice;
    }
    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsAttribute that = (GoodsAttribute) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(goodsId, that.goodsId) &&
                Objects.equals(attrId, that.attrId) &&
                Objects.equals(attrName, that.attrName) &&
                Objects.equals(attrValue, that.attrValue) &&
                Objects.equals(attrPrice, that.attrPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, goodsId, attrId, attrName, attrValue, attrPrice);
    }

    @Override
    public String toString() {
        return "GoodsAttribute{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", attrId=" + attrId +
                ", attrName='" + attrName + '\'' +
                ", attrValue='" + attrValue + '\'' +
                ", attrPrice=" + attrPrice +
                '}';
    }
}