/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserAddService
 * Author: Zi
 * Date: 2019/4/16 16:21
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
package com.zi.mall.service;

import com.zi.mall.domain.UserAdd;
import com.zi.mall.vo.DataAndView;

import java.util.List;

/**
 * 〈〉
 *
 * @author Zi
 * @create 2019/4/16
 * @since 1.0.0
 */
public interface UserAddService {
    /**
     * 分页查询用户地址
     *
     * @param page
     * @param limit
     * @param userId
     * @return
     */
    DataAndView<UserAdd> queryUserAdd(Integer page, Integer limit, Integer userId);

    /**
     * 添加
     *
     * @param userAdd
     */
    void addAddress(UserAdd userAdd);

    /**
     * 删除
     *
     * @param id
     */
    void deleteUseradd(Integer id);

    /**
     * 查询用户的所有地址
     */
    List<UserAdd> queryAll(Integer userId);
}