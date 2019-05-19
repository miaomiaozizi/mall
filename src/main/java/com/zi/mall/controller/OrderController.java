/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: OrderController
 * Author: Zi
 * Date: 2019/4/18 15:25
 * Description: 订单控制器
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.controller;

import com.zi.mall.domain.Goods;
import com.zi.mall.domain.Order;
import com.zi.mall.domain.User;
import com.zi.mall.domain.UserAdd;
import com.zi.mall.model.LayuiTableModel;
import com.zi.mall.service.GoodsService;
import com.zi.mall.service.OrderService;
import com.zi.mall.service.UserAddService;
import com.zi.mall.vo.DataAndView;
import com.zi.mall.vo.GoodsVo;
import com.zi.mall.vo.OrderVo;
import com.zi.mall.vo.PayVo;
import com.zi.mall.vo.Result;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

/**
 * 订单控制器
 *
 * @author Zi
 * @create 2019/4/18
 * @since 1.0.0
 */
@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserAddService userAddService;
    @Autowired
    private GoodsService goodsService;

    /**
     * 分页查询客户订单
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @GetMapping("order")
    public LayuiTableModel<Order> getOrderList(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit,HttpSession session) {
        User user = (User) session.getAttribute("user");
        DataAndView orderList = orderService.getOrderList(page, limit, user.getId());
        return new LayuiTableModel<>(0,"",orderList.getCount(),orderList.getData());

    }
    /**
     * 跳转创建订单页面
     */
    @RequestMapping("addOrder")
    public String addOrder(OrderVo orderVo, HttpSession session, Model model){
        //查询当前用户的所有地址
         User user = (User) session.getAttribute("user");
        List<UserAdd> userAdds = userAddService.queryAll(user.getId());
        //查询订单对应的商品
        List<Integer> ids=new ArrayList<>();
        List<GoodsVo> goodsVoList=orderVo.getGoodslist();
        //获取所有的商品id
        for (GoodsVo goodsVo : goodsVoList) {
            ids.add(goodsVo.getId());
        }
        //根据商品id查出商品详细信息
        List<Goods> goods = goodsService.queryByIdList(ids);
        //将商品详细信息复制到goodsVo对象中
        for (Goods good : goods) {
            for (GoodsVo goodsVo : goodsVoList) {
                if (good.getId().equals(goodsVo.getId())){
                    //复制属性
                    BeanUtils.copyProperties(good,goodsVo);
                }
            }
        }
        //设置订单总价
         BigDecimal totalPrice = new BigDecimal("0");

        for (GoodsVo goodsVo : goodsVoList) {
            //设置单个商品小结价格
            BigDecimal multiply = goodsVo.getShopPrice().multiply(new BigDecimal(goodsVo.getNumber()));
            goodsVo.setTotalPrice(multiply);
           totalPrice= totalPrice.add(goodsVo.getTotalPrice());
        }
        orderVo.setPrice(totalPrice);
        model.addAttribute("userAdds", userAdds);
        model.addAttribute("order",orderVo);
        return "protal/addOrder";
    }
    /**
     * 确认订单
     */
    @RequestMapping("orderConfirm")
    public String orderConfirm(OrderVo orderVo,HttpSession session,Model model){
        User user = (User) session.getAttribute("user");
        //设置用户id
        orderVo.setUserId(user.getId());
        PayVo payVo = orderService.addOrder(orderVo);
        model.addAttribute("payVo",payVo);
        /**
         * 跳转支付页面
         */
        return "protal/toPay";
    }
    /**
     * 分页查询所有订单
     */
    @RequestMapping("orderList")
    @ResponseBody
    public LayuiTableModel<OrderVo> queryAll(OrderVo orderVo){
        return orderService.queryAll(orderVo);
    }
    /**
     * 发货
     */
    @ResponseBody
    @RequestMapping("order/ship")
    public Result ship(Order order){
        order.setState("1");
        orderService.ship(order);
        return new Result(200,"发货成功",null);
    }

}
