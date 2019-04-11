/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: UserServiceImpl
 * Author: Zi
 * Date: 2019/4/11 16:00
 * Description: 用户服务实现类
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.service.impl;

import com.zi.mall.domain.User;
import com.zi.mall.mapper.UserMapper;
import com.zi.mall.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现类
 *
 * @author Zi
 * @create 2019/4/11
 * @since 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        return userMapper.selectByUserNameAndPassword(user);
    }
}
