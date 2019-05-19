/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: LoginInterceptor
 * Author: Zi
 * Date: 2019/5/10 13:25
 * Description: 登陆拦截器
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆拦截器
 *
 * @author Zi
 * @create 2019/5/10
 * @since 1.0.0
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object object = request.getSession().getAttribute("user");
        if(null!=object) {
            return true;
        }else {
            response.sendRedirect("/login");
            return false;
        }
    }
}
