/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: UserAddServiceImpl
 * Author: Zi
 * Date: 2019/4/16 16:24
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zi.mall.domain.UserAdd;
import com.zi.mall.domain.UserAddExample;
import com.zi.mall.mapper.AreaMapper;
import com.zi.mall.mapper.UserAddMapper;
import com.zi.mall.service.UserAddService;
import com.zi.mall.vo.DataAndView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zi
 * @create 2019/4/16
 * @since 1.0.0
 */
@Service
public class UserAddServiceImpl implements UserAddService {
    @Autowired
    private UserAddMapper mapper;
    @Autowired
    private AreaMapper areaMapper;

    @Override
    public DataAndView<UserAdd> queryUserAdd(Integer page, Integer limit, Integer userId) {
        UserAddExample example = new UserAddExample();
        UserAddExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        Page<Object> startPage = PageHelper.startPage(page, limit);
        List<UserAdd> userAdds = mapper.selectByExample(example);
        for (UserAdd userAdd : userAdds) {
            userAdd.setAddress(userAdd.getProvince() + userAdd.getCity() + userAdd.getDistrict() + userAdd.getAddress());
        }
        return new DataAndView<>(startPage.getTotal(), userAdds);
    }

    @Override
    public void addAddress(UserAdd userAdd) {
        if (userAdd.getIsDefault() == 1) {
            mapper.updateDefaultAddress(userAdd.getUserId());
        }
        userAdd.setProvince(areaMapper.selectByPrimaryKey(Integer.valueOf(userAdd.getProvince())).getAreaname());
        userAdd.setCity(areaMapper.selectByPrimaryKey(Integer.valueOf(userAdd.getCity())).getAreaname());
        userAdd.setDistrict(areaMapper.selectByPrimaryKey(Integer.valueOf(userAdd.getDistrict())).getAreaname());
        mapper.insert(userAdd);
    }

    @Override
    public void deleteUseradd(Integer id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<UserAdd> queryAll(Integer userId) {
        UserAddExample example = new UserAddExample();
        UserAddExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<UserAdd> userAdds = mapper.selectByExample(example);
        for (UserAdd userAdd : userAdds) {
            userAdd.setAddress(userAdd.getProvince() + userAdd.getCity() + userAdd.getDistrict() + userAdd.getAddress());
        }
        return userAdds;
    }
}
