/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: UserController
 * Author: Zi
 * Date: 2019/4/16 15:40
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.controller;

import com.zi.mall.domain.Area;
import com.zi.mall.domain.User;
import com.zi.mall.domain.UserAdd;
import com.zi.mall.model.AreaJson;
import com.zi.mall.model.LayuiTableModel;
import com.zi.mall.service.AreaService;
import com.zi.mall.service.UserAddService;
import com.zi.mall.vo.DataAndView;
import com.zi.mall.vo.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

/**
 * @author Zi
 * @create 2019/4/16
 * @since 1.0.0
 */
@Controller
public class UserController {
    @Autowired
    private UserAddService userAddService;
    @Autowired
    private AreaService areaService;

    /**
     * 跳转用户地址管理页面
     * @return
     */
    @RequestMapping("useradd")
    public String toUserAdd() {
        return "protal/useradd";
    }

    /**
     * 查询用户的收货地址
     */
    @RequestMapping("userAddress")
    @ResponseBody
    public LayuiTableModel<UserAdd> queryAddByUserId(Integer page, Integer limit,HttpSession session) {
        User user = (User) session.getAttribute("user");
        DataAndView<UserAdd> dataAndView = userAddService.queryUserAdd(page, limit, user.getId());
        return new LayuiTableModel<>(0, "", dataAndView.getCount(), dataAndView.getData());
    }

    /**
     * 省市区联动数据接口
     */
    @ResponseBody
    @RequestMapping("getArea")
    public List<AreaJson> getArea(@RequestParam(defaultValue = "1") Integer id) {
        List<Area> areas = areaService.getAreaByPid(id);
        ArrayList<AreaJson> areaJsons = new ArrayList<>();
        for (Area area : areas) {
            areaJsons.add(new AreaJson(area.getId(), area.getAreaname()));
        }
        return areaJsons;
    }

    /**
     * 、
     * <p>
     * 添加地址
     *
     * @param userAdd
     * @param isDefaultstr
     * @return
     */
    @PostMapping("useradd")
    @ResponseBody
    public Result addUseradd(UserAdd userAdd, String isDefaultstr, HttpSession session) {
        userAdd.setIsDefault(isDefaultstr.equals("on") ? (byte) 1 : (byte) 0);
        User user = (User)session.getAttribute("user");
        userAdd.setUserId(user.getId());
        userAddService.addAddress(userAdd);
        return Result.ok();
    }

    /**
     * 删除地址
     * @param id
     * @return
     */
    @PostMapping("deleteUserAdd")
    @ResponseBody
    public Result deletdUseradd(Integer id){
        userAddService.deleteUseradd(id);
        return Result.ok();
    }
    /**
     * 跳转我的收藏
     */
    @RequestMapping("usercol")
    public String toUserCol(){
        return "protal/usercol";
    }
    /**
     * 跳转个人中心
     */
    @RequestMapping("user")
    public String toUser(){
        return "protal/user";
    }
    /**
     * 获取用户名与id
     */
    @ResponseBody
    @RequestMapping("/getUser")
    public User getUser(HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user!=null){
            user.setPassword("****");
        }
        return user;
    }
}
