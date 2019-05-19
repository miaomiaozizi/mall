/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: CatService
 * Author: Zi
 * Date: 2019/4/23 13:24
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.service;

import com.zi.mall.domain.ContentCategory;
import com.zi.mall.model.LayuiTableModel;

import java.util.List;

/**
 *
 *
 * @author Zi
 * @create 2019/4/23
 * @since 1.0.0
 */
public interface CatService {
    List<ContentCategory> queryAllContentCategory();
    /**
     * 分页查询
     */
    LayuiTableModel<ContentCategory> queryByPage(Integer page,Integer limit);
    /**
     * 增
     */
    void add(ContentCategory category);
    /**
     * 删
     */
    void delete(Integer id);
    /**
     * 改
     */
    void update(ContentCategory category);
 }
