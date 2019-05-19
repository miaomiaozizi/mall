/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ShopService
 * Author: Zi
 * Date: 2019/4/30 14:00
 * Description: 购物车服务
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
package com.zi.mall.service;

import com.zi.mall.domain.Shop;
import com.zi.mall.model.LayuiTableModel;
import com.zi.mall.vo.ShopVo;

/**
 * 〈购物车服务〉
 *
 * @author Zi
 * @create 2019/4/30
 * @since 1.0.0
 */
public interface ShopService {
    LayuiTableModel<ShopVo> queryByPage(Integer page, Integer limit, Integer userId);

    void addGoods(Shop shop);

    Integer getShopNumber(Integer id);

    void deleteShop(Integer id);
}