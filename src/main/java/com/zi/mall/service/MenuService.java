/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: MenuService
 * Author: Zi
 * Date: 2019/4/20 16:49
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.service;

import com.zi.mall.domain.Available;
import com.zi.mall.vo.AvailableVo;

import java.util.List;

/**
 *
 *
 * @author Zi
 * @create 2019/4/20
 * @since 1.0.0
 */
public interface MenuService {
List<Available> queryMenuByUserId(AvailableVo availableVo,Integer userId);

}
