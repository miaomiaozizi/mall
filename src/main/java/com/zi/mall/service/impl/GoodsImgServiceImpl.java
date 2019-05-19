/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: GoodsImgServiceImpl
 * Author: Zi
 * Date: 2019/4/13 11:16
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.service.impl;

import com.zi.mall.domain.GoodsImg;
import com.zi.mall.mapper.GoodsImgMapper;
import com.zi.mall.service.GoodsImgService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 *
 * @author Zi
 * @create 2019/4/13
 * @since 1.0.0
 */
@Service
public class GoodsImgServiceImpl implements GoodsImgService {
    @Autowired
    private GoodsImgMapper mapper;

    @Override
    public List<GoodsImg> queryGoodsImgById(Integer id) {
        return mapper.selectGoodsImgs(id);
    }

    @Override
    public void add(GoodsImg goodsImg) {
        mapper.insert(goodsImg);
    }

    @Override
    public void updateGoodsImg(GoodsImg goodsImg) {
        mapper.updateGoodsImg(goodsImg);
    }
}
