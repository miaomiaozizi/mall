/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: GoodsDetailServiceImpl
 * Author: Zi
 * Date: 2019/4/13 15:16
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.service.impl;

import com.zi.mall.domain.GoodsDetails;
import com.zi.mall.domain.GoodsDetailsExample;
import com.zi.mall.mapper.GoodsDetailsMapper;
import com.zi.mall.service.GoodsDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zi
 * @create 2019/4/13
 * @since 1.0.0
 */
@Service
public class GoodsDetailServiceImpl implements GoodsDetailService {
    @Autowired
    private GoodsDetailsMapper mapper;
    @Override
    public List<GoodsDetails> queryDetailsById(Integer id) {
        GoodsDetailsExample example = new GoodsDetailsExample();
        GoodsDetailsExample.Criteria criteria = example.createCriteria();
        criteria.andGoodsIdEqualTo(id);
        return mapper.selectByExample(example);
    }

    @Override
    public void addGoodsDetails(GoodsDetails goodsDetails) {
        mapper.insert(goodsDetails);
    }

    @Override
    public void updateGoodsDetails(GoodsDetails goodsDetails) {
            mapper.updateImgUrl(goodsDetails);
    }
}
