/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: GoodsCommentServiceImpl
 * Author: Zi
 * Date: 2019/4/13 16:26
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zi.mall.domain.GoodsComment;
import com.zi.mall.domain.GoodsCommentExample;
import com.zi.mall.mapper.GoodsCommentMapper;
import com.zi.mall.service.GoodsCommentService;

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
public class GoodsCommentServiceImpl implements GoodsCommentService {

    @Autowired
    private GoodsCommentMapper mapper;
    @Override
    public List<GoodsComment> queryGoodsComment(Integer page, Integer limit, Integer goodsId) {
        Page<Object> startPage = PageHelper.startPage(page, limit);
        GoodsCommentExample example = new GoodsCommentExample();
        GoodsCommentExample.Criteria criteria = example.createCriteria();
        criteria.andGoodsIdEqualTo(goodsId);
        List<GoodsComment> goodsComments = mapper.selectByExample(example);
        return goodsComments;
    }
}
