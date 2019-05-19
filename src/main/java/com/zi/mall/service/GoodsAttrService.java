/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: GoodsAttrService
 * Author: Zi
 * Date: 2019/4/12 16:02
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
package com.zi.mall.service;

import com.zi.mall.domain.GoodsAttribute;

import java.util.List;

/**
 * 〈〉
 * @author Zi
 * @create 2019/4/12
 * @since 1.0.0
 */
public interface GoodsAttrService {
    List<GoodsAttribute> queryGoodsAttr(Integer goodsId);

}