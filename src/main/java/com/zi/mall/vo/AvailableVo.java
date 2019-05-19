/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: AvailableVo
 * Author: Zi
 * Date: 2019/4/20 16:56
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.vo;

import com.zi.mall.domain.Available;

/**
 * @author Zi
 * @create 2019/4/20
 * @since 1.0.0
 */
public class AvailableVo extends Available {
    private Integer page;
    private Integer limit;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
