/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: AreaService
 * Author: Zi
 * Date: 2019/4/17 16:14
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.service;

import com.zi.mall.domain.Area;

import java.util.List;

/**
 * @author Zi
 * @create 2019/4/17
 * @since 1.0.0
 */
public interface AreaService {
    /**
     * 根据父id查询下面的节点
     * @param pid
     * @return
     */
    List<Area> getAreaByPid(Integer pid);

}
