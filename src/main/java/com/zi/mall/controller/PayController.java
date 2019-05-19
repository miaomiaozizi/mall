/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: PayController
 * Author: Zi
 * Date: 2019/5/8 14:35
 * Description: 支付控制器
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.controller;

import com.zi.mall.domain.Order;
import com.zi.mall.service.OrderService;
import com.zi.mall.service.PayService;
import com.zi.mall.vo.PayVo;
import com.zi.mall.vo.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/**
 * 支付控制器
 *
 * @author Zi
 * @create 2019/5/8
 * @since 1.0.0
 */
@Controller
public class PayController {
    @Autowired
    private PayService payService;
    @Autowired
    private OrderService orderService;

    /**
     * 跳转支付页面
     */
    @RequestMapping(path = "toPay", produces = "text/plain;charset=UTF-8")
    public void toPay(PayVo payVo, HttpServletResponse response) {
        String pageHtml = "<!DOCTYPE html><html><head><meta charset=\"utf-8\"></head><body>";
        String result = payService.toPay(payVo);
        pageHtml += result;
        pageHtml += "</body></html>";
        response.setContentType("text/html;charset=utf-8");
        try {
            response.getWriter().write(pageHtml);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 支付宝重定向页面接口 return_url
     */
    @RequestMapping("pay/return")
    public String returnPage(String out_trade_no, String trade_no, String total_amount, Model model) {
        PayVo payVo = new PayVo(out_trade_no, "", total_amount, "");
        Order order = new Order();
        order.setOrderid(out_trade_no);
        order.setOddno(trade_no);
        orderService.updateOrderOddno(order);
        model.addAttribute("payVo", payVo);
        return "protal/wait";
    }

    /**
     * notify_url接口
     *
     * @param out_trade_no 订单号
     * @param trade_status 交易状态
     * @return 除了结果
     */
    @PostMapping("/pay/notify")
    @ResponseBody
    public String notifyPage(String out_trade_no, String trade_status) {
        //如果交易状态为成功
        if (trade_status.equals("TRADE_SUCCESS")) {
            //修改订单状态为已支付
            orderService.updateOrderStart(out_trade_no);
            return "success";
        } else {
            return "fail";
        }
    }

    /**
     * 查询订单状态
     */
    @RequestMapping("queryOrder")
    @ResponseBody
    public Result queryOrder(String orderid) {
        Order order = orderService.queryOrderStart(orderid);
        if (order.getState().equals("0")) {
            return Result.ok();
        } else {
            return Result.error();
        }
    }
}
