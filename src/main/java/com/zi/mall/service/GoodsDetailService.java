/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: GoodsDetailService
 * Author: Zi
 * Date: 2019/4/13 15:14
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.service;

import com.zi.mall.domain.Goods;
import com.zi.mall.domain.GoodsDetails;

import java.util.List;

/**
 * @author Zi
 * @create 2019/4/13
 * @since 1.0.0
 */
public interface GoodsDetailService {

    List<GoodsDetails> queryDetailsById(Integer id);

    /**
     * 添加
     * @param goodsDetails
     */
    void  addGoodsDetails(GoodsDetails goodsDetails);
    /**
     * 修改
     */
    void  updateGoodsDetails(GoodsDetails goodsDetails);
}
