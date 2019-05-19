/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: LoginController
 * Author: Zi
 * Date: 2019/4/11 14:51
 * Description: 登陆控制器
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.controller;

import com.zi.mall.domain.User;
import com.zi.mall.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

import sun.security.util.Password;

/**
 * 登陆控制器
 *
 * @author Zi
 * @create 2019/4/11
 * @since 1.0.0
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    /**
     * 跳转登陆页面
     *
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "protal/login";
    }

    /**
     * 登陆
     *
     * @return
     */
    @RequestMapping("/login")
    public String login(User user, Model model, HttpSession session) {
        User login = userService.login(user);
        if (login == null) {
            model.addAttribute("msg", "用户名或密码错误");
            return "protal/login";
        } else {
            session.setAttribute("user", login);
            return "redirect:/";
        }
    }

    /**
     * 后台管理登陆页面
     *
     * @return
     */
    @RequestMapping("admin/login")
    public String adminLogin(User user, Model model, HttpSession session) {
        User login = userService.login(user);
        if (login != null && !"admin".equals(user.getRole())) {
            session.setAttribute("user", login);
            return "redirect:/admin";
        } else {
            model.addAttribute("msg", "用户名或密码错误");
            return "/admin/login";
        }
    }
}
