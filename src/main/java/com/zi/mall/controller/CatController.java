/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: CatController
 * Author: Zi
 * Date: 2019/4/22 19:21
 * Description: 商品类别控制器
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.controller;

import com.zi.mall.domain.ContentCategory;
import com.zi.mall.model.LayuiTableModel;
import com.zi.mall.service.CatService;
import com.zi.mall.vo.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 商品类别控制器
 *
 * @author Zi
 * @create 2019/4/22
 * @since 1.0.0
 */
@Controller
public class CatController {
    @Autowired
    private CatService catService;

    /**
     * 查询所有的商品类别
     */
    @ResponseBody
    @RequestMapping("/allGoodsCategory")
    public List<ContentCategory> queryAllCat() {
        return catService.queryAllContentCategory();
    }

    @ResponseBody
    @RequestMapping("categoryList")
    public LayuiTableModel<ContentCategory> queryCatByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit) {
        return catService.queryByPage(page, limit);
    }

    /**
     * 添加商品分类
     */
    @ResponseBody
    @RequestMapping("addCat")
    public Result addCat(ContentCategory category) {
        catService.add(category);
        return Result.ok();
    }

    /**
     * 修改商品分类
     */
    @ResponseBody
    @RequestMapping("updateCat")
    public Result updateCat(ContentCategory category) {
        catService.update(category);
        return Result.ok();
    }

    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping("deleteCat")
    public Result deleteCat(Integer id) {
        catService.delete(id);
        return Result.ok();
    }

}
