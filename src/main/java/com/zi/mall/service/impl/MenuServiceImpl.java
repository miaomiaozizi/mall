/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: MenuServiceImpl
 * Author: Zi
 * Date: 2019/4/20 16:59
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.service.impl;

import com.zi.mall.domain.Available;
import com.zi.mall.domain.AvailableExample;
import com.zi.mall.mapper.AvailableMapper;
import com.zi.mall.service.MenuService;
import com.zi.mall.vo.AvailableVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 *
 * @author Zi
 * @create 2019/4/20
 * @since 1.0.0
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private AvailableMapper availableMapper;

    @Override
    public List<Available> queryMenuByUserId(AvailableVo availableVo, Integer userId) {
        AvailableExample example = new AvailableExample();
        AvailableExample.Criteria criteria = example.createCriteria();
        criteria.andTypeEqualTo("menu").andAvailableEqualTo(1);
        List<Available> menus = availableMapper.selectByExample(example);
        return menus;
    }
}
