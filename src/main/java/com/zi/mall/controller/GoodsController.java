/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: GoodsController
 * Author: Zi
 * Date: 2019/4/11 16:35
 * Description: 商品控制器
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.controller;

import com.zi.mall.domain.Goods;
import com.zi.mall.domain.GoodsComment;
import com.zi.mall.domain.GoodsDetails;
import com.zi.mall.domain.GoodsImg;
import com.zi.mall.model.LayuiTableModel;
import com.zi.mall.service.GoodsCommentService;
import com.zi.mall.service.GoodsDetailService;
import com.zi.mall.service.GoodsImgService;
import com.zi.mall.service.GoodsService;
import com.zi.mall.vo.GoodsVo;
import com.zi.mall.vo.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 商品控制器
 *
 * @author Zi
 * @create 2019/4/11
 * @since 1.0.0
 */
@Controller
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsImgService imgService;
    @Autowired
    private GoodsDetailService detailService;
    @Autowired
    private GoodsCommentService commentService;

    /**
     * 跳转商品详情页面
     */
    @RequestMapping("toDetail")
    public String toDetail(@RequestParam Integer id, Model model) {
        GoodsVo goods = goodsService.queryGoods(id);
        List<Goods> hotGoods = goodsService.getHotGoods(4);
        List<GoodsImg> goodsImgs = imgService.queryGoodsImgById(id);
        List<GoodsDetails> goodsDetails = detailService.queryDetailsById(id);
        List<GoodsComment> goodsComments = commentService.queryGoodsComment(0, 10, 1);
        model.addAttribute("goodsImgs", goodsImgs);
        model.addAttribute("goods", goods);
        model.addAttribute("hotGoods", hotGoods);
        model.addAttribute("goodsDetails", goodsDetails);
        model.addAttribute("goodsComment", goodsComments);
        return "protal/detail";
    }

    /**
     * 跳转商品列表页面
     */
    @RequestMapping("list")
    public String toGoodsList(String GoodsName, Integer catId, Model model) {
        if (catId != null) {
            List<Goods> goods = goodsService.queryGoodsByCatId(1, 20, catId);
            model.addAttribute("goods", goods);
        } else if (GoodsName != null){
            List<Goods> goods = goodsService.queryGoodsByGoodsName(1, 20, GoodsName);
            model.addAttribute("goods", goods);
        }
            return "protal/list";
    }

    /**
     * 分页查询商品
     */
    @RequestMapping("/GoodsList")
    @ResponseBody
    public LayuiTableModel<GoodsVo> loadGoodsList(GoodsVo goodsVo) {
        return goodsService.queryGoods(goodsVo);
    }

    /**
     * 添加商品介绍图片
     */
    @ResponseBody
    @PostMapping("goodsImgs")
    public Result<Object> addGoodsImgs(GoodsImg goodsImg) {
        if (goodsImg.getGoodsId() == null) {
            imgService.add(goodsImg);
        } else {
            imgService.updateGoodsImg(goodsImg);
        }

        return Result.ok();
    }

    /**
     * 添加商品详情图片
     */
    @ResponseBody
    @PostMapping("GoodsDetails")
    public Result addGoodsDetails(GoodsDetails goodsDetails) {
        if (goodsDetails.getGoodsId() == null) {
            detailService.addGoodsDetails(goodsDetails);
        } else {
            detailService.updateGoodsDetails(goodsDetails);
        }

        return Result.ok();
    }

    /**
     * 添加商品
     */
    @ResponseBody
    @RequestMapping("/addGoods")
    public Result addGoods(Goods goods) {
        goodsService.addGoods(goods);
        return Result.ok();
    }

    /**
     * 删除商品
     */
    @ResponseBody
    @RequestMapping("/deleteGoods")
    public Result deleteGoods(Integer goodsId) {
        goodsService.deleteGoods(goodsId);
        return Result.ok();
    }

    /**
     * 修改商品
     */
    @RequestMapping("updateGoods")
    @ResponseBody
    public Result updateGoods(Goods goods) {
        goodsService.updateGoods(goods);
        return Result.ok();
    }
}
