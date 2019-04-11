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

}