/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: GoodsCommentService
 * Author: Zi
 * Date: 2019/4/13 15:59
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
package com.zi.mall.service;

import com.zi.mall.domain.GoodsComment;

import java.util.List;

/**
 * 〈〉
 * @author Zi
 * @create 2019/4/13
 * @since 1.0.0
 */
public interface GoodsCommentService {
    /**
     * 分页查询商品评论
     * @param page
     * @param limit
     * @param goodsId
     * @return
     */
    List<GoodsComment> queryGoodsComment(Integer page,Integer limit,Integer goodsId );
}