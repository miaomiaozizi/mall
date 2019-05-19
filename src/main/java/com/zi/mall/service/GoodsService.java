/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: GoodsService
 * Author: Zi
 * Date: 2019/4/8 16:41
 * Description: 商品服务
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
package com.zi.mall.service;


import com.zi.mall.domain.Goods;
import com.zi.mall.model.LayuiTableModel;
import com.zi.mall.vo.GoodsVo;

import java.util.List;

/**
 * 〈商品服务〉
 * @author Zi
 * @create 2019/4/8
 * @since 1.0.0
 */
public interface GoodsService {
    /**
     * 查询热销商品
     */
    List<Goods> getHotGoods(Integer sum);
    /**
     * 查询新品
     */
    List<Goods> getNewGoods(Integer sum);
    /**
     * 查询商品
     */
    GoodsVo queryGoods(Integer id);
    /**
     * 根据商品分类id查询商品
     */
    List<Goods> queryGoodsByCatId(Integer page,Integer pageSize,Integer catId);
    /**
     * 分页加模糊查询商品列表
     */
    LayuiTableModel<GoodsVo> queryGoods(GoodsVo goodsVo);
    /**
     * 添加商品
     */
    void addGoods(Goods goods);

    void deleteGoods(Integer goodsId);

    void updateGoods(Goods goods);
    /**
     * 根据商品id集合查询商品
     */
    List<Goods> queryByIdList(List<Integer> ids);

    List<Goods> queryGoodsByGoodsName(int page, int pageSize, String goodsName);
}