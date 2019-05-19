/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: IndexController
 * Author: Zi
 * Date: 2019/4/8 16:13
 * Description: 跳转首页控制器
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.controller;

import com.zi.mall.domain.Goods;
import com.zi.mall.domain.User;
import com.zi.mall.service.GoodsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import javax.servlet.http.HttpSession;

/**
 * 跳转首页控制器
 *
 * @author Zi
 * @create 2019/4/8
 * @since 1.0.0
 */
@Controller
public class IndexController {
    @Autowired
    private GoodsService goodsService;

    /**
     * 跳转首页
     *
     * @return
     */
    @RequestMapping("/")
    public String index(Model model) {
        /**
         * 查询热销商品
         */
        List<Goods> hotGoods = goodsService.getHotGoods(4);
        //查询新品
        List<Goods> newGoods = goodsService.getNewGoods(4);
        model.addAttribute("hotGoods",hotGoods);
        model.addAttribute("newGoods",newGoods);
        return "protal/index";
    }
    @RequestMapping("/admin")
    public String toAdminIndex(HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user==null){
            return "admin/login";
        }else {
            if ("admin".equals(user.getRole())){
                return "admin/index";
            }
            return "admin/login";
        }

    }
}
