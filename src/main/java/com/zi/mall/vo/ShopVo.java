/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: ShopVo
 * Author: Zi
 * Date: 2019/4/30 14:08
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.vo;

import com.zi.mall.domain.Shop;

/**
 * @author Zi
 * @create 2019/4/30
 * @since 1.0.0
 */
public class ShopVo extends Shop {
    /**
     * 商品id
     */
    private String name;
    /**
     * 商品颜色
     */
    private String color;
    /**
     * 功率
     */
    private String wattage;
    /**
     * 商品图像
     */
    private String avatar;
    /**
     * 商品价格
     */
    private String price;
    /**
     * 原价
     */
    private String original;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getWattage() {
        return wattage;
    }

    public void setWattage(String wattage) {
        this.wattage = wattage;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public ShopVo(String name, String avatar, String price, String original) {
        this.name = name;
        this.avatar = avatar;
        this.price = price;
        this.original = original;
    }
}
