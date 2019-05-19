/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: GoodsAttrServiceImpl
 * Author: Zi
 * Date: 2019/4/12 16:03
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.service.impl;

import com.zi.mall.domain.GoodsAttribute;
import com.zi.mall.mapper.GoodsAttributeMapper;
import com.zi.mall.service.GoodsAttrService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 *
 * @author Zi
 * @create 2019/4/12
 * @since 1.0.0
 */
@Service
public class GoodsAttrServiceImpl implements GoodsAttrService {
    @Autowired
    private GoodsAttributeMapper mapper;

    @Override
    public List<GoodsAttribute> queryGoodsAttr(Integer goodsId) {
        return this.mapper.selectGoodsAttrById(goodsId);
    }
}
