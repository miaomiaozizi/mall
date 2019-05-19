/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: ShopController
 * Author: Zi
 * Date: 2019/4/30 13:49
 * Description: 购物车控制器
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.controller;

import com.alipay.api.request.AlipayPointBalanceGetRequest;
import com.zi.mall.domain.Shop;
import com.zi.mall.domain.User;
import com.zi.mall.model.LayuiTableModel;
import com.zi.mall.service.ShopService;
import com.zi.mall.vo.OrderVo;
import com.zi.mall.vo.Result;
import com.zi.mall.vo.ShopVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 购物车控制器
 *
 * @author Zi
 * @create 2019/4/30
 * @since 1.0.0
 */
@Controller
public class ShopController {
    @Autowired
    private ShopService shopService;

    /**
     * 跳转购物车页面
     */
    @RequestMapping("toUserShop")
    public String toUserShop() {
        return "protal/usershop";
    }

    /**
     * 分页查询购物车中商品列表
     */
    @RequestMapping("shop")
    @ResponseBody
    public LayuiTableModel<ShopVo> queryShopByPage(Integer page, Integer limit, HttpSession session) {
        User user = (User) session.getAttribute("user");
        return shopService.queryByPage(page, limit, user.getId());
    }
    /**
     * 购物车添加商品
     */
    @RequestMapping("/addShop")
    @ResponseBody
    public Result shopAddGoods(OrderVo orderVo, HttpSession session){
        Shop shop = new Shop();
        shop.setGoodsId(orderVo.getGoodslist().get(0).getId());
        shop.setNumber(orderVo.getGoodslist().get(0).getNumber());
        User user = (User) session.getAttribute("user");
        if (user==null){
            return Result.error();
        }
        shop.setUserId(user.getId());
        shopService.addGoods(shop);
        return Result.ok();
    }
    /**
     * 获取用户购物车初始商品数量
     */
    @RequestMapping("getShopNumber")
    @ResponseBody
    public Integer getShopNumber(HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user==null){
            return 0;
        }else {
            return shopService.getShopNumber(user.getId());
        }
    }
    /**
     * 删除购物车记录
     */
    @ResponseBody
    @RequestMapping("deleteShop")
    public Result deleteShop(Integer id){
        shopService.deleteShop(id);
        return Result.ok();
    }
}
