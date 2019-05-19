/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: WebApplicationConfig
 * Author: Zi
 * Date: 2019/5/10 13:29
 * Description: web应用配置
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.config;

import com.zi.mall.interceptor.LoginInterceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;

/**
 * web应用配置
 *
 * @author Zi
 * @create 2019/5/10
 * @since 1.0.0
 */
@Configuration
public class WebApplicationConfig implements WebMvcConfigurer {

    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        ArrayList<String> excludePath = new ArrayList<>();
        excludePath.add("/admin/**");
        excludePath.add("/html/**");
        excludePath.add("/res/**");
        excludePath.add("/resources/**");
        ArrayList<String> interceptorPath = new ArrayList<>();
        interceptorPath.add("/toUserShop");
        interceptorPath.add("/addShop");
        interceptorPath.add("/shop");
        interceptorPath.add("/order");
        interceptorPath.add("/addOrder");
        interceptorPath.add("/orderConfirm");
        interceptorPath.add("/user");
        interceptorPath.add("/usercol");
        interceptorPath.add("/useradd");
        registry.addInterceptor(loginInterceptor()).excludePathPatterns(excludePath).addPathPatterns(interceptorPath);
    }
}
