/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: DataAndView
 * Author: Zi
 * Date: 2019/4/16 16:22
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.vo;

import java.util.List;

/**
 * @author Zi
 * @create 2019/4/16
 * @since 1.0.0
 */
public class DataAndView<T> {
    private Long count;
    private List<T> data;



    public void setCount(Long count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public DataAndView() {
    }



    public DataAndView(Long count, List<T> data) {
        this.count = count;
        this.data = data;
    }

    public Long getCount() {
        return count;
    }
}
