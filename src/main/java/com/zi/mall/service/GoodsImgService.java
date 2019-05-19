/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: GoodsImgService
 * Author: Zi
 * Date: 2019/4/13 11:15
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
package com.zi.mall.service;

import com.zi.mall.domain.GoodsImg;

import java.util.List;

/**
 * 〈〉
 * @author Zi
 * @create 2019/4/13
 * @since 1.0.0
 */
public interface GoodsImgService {
    List<GoodsImg> queryGoodsImgById(Integer id);
    void add(GoodsImg goodsImg);
    void updateGoodsImg(GoodsImg goodsImg);
}