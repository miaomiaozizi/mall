/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserService
 * Author: Zi
 * Date: 2019/4/11 15:59
 * Description: 用户服务
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
package com.zi.mall.service;

import com.zi.mall.domain.User;

/**
 * 〈用户服务〉
 * @author Zi
 * @create 2019/4/11
 * @since 1.0.0
 */
public interface UserService {
    /**
     * 用户登陆
     * @param user
     * @return
     */
    User login(User user);

}