/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: AreaServiceImpl
 * Author: Zi
 * Date: 2019/4/17 16:17
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.service.impl;

import com.zi.mall.domain.Area;
import com.zi.mall.domain.AreaExample;
import com.zi.mall.mapper.AreaMapper;
import com.zi.mall.service.AreaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zi
 * @create 2019/4/17
 * @since 1.0.0
 */
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaMapper mapper;

    @Override
    public List<Area> getAreaByPid(Integer pid) {
        AreaExample example = new AreaExample();
        AreaExample.Criteria criteria = example.createCriteria();
        criteria.andParentidEqualTo(pid);
        List<Area> areas = mapper.selectByExample(example);
        return areas;
    }
}
