/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: CatServiceImpl
 * Author: Zi
 * Date: 2019/4/23 13:26
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zi.mall.domain.ContentCategory;
import com.zi.mall.domain.ContentCategoryExample;
import com.zi.mall.mapper.ContentCategoryMapper;
import com.zi.mall.model.LayuiTableModel;
import com.zi.mall.service.CatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zi
 * @create 2019/4/23
 * @since 1.0.0
 */
@Service
public class CatServiceImpl implements CatService {
    @Autowired
    private ContentCategoryMapper mapper;

    @Override
    public List<ContentCategory> queryAllContentCategory() {
        ContentCategoryExample example = new ContentCategoryExample();
        ContentCategoryExample.Criteria criteria = example.createCriteria();
        //查询所有可用的商品类别
        criteria.andStatusEqualTo(1);
        return mapper.selectByExample(example);
    }

    @Override
    public LayuiTableModel<ContentCategory> queryByPage(Integer page, Integer limit) {
        Page<Object> objects = PageHelper.startPage(page, limit);
        List<ContentCategory> contentCategories = mapper.selectByExample(null);
        return new LayuiTableModel<>(0, "", objects.getTotal(), contentCategories);
    }

    @Override
    public void add(ContentCategory category) {
        mapper.insertSelective(category);
    }

    @Override
    public void delete(Integer id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(ContentCategory category) {
        mapper.updateByPrimaryKeySelective(category);
    }
}
