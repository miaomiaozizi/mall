/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: LayuiTableModel
 * Author: Zi
 * Date: 2019/4/16 15:53
 * Description: layui表格模型对象
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.model;

import java.util.List;

/**
 * layui表格模型对象
 *
 * @author Zi
 * @create 2019/4/16
 * @since 1.0.0
 */
public class LayuiTableModel<T> {
    private Integer code;
    private String msg;
    private Long count;
    private List<T> data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public LayuiTableModel(Integer code, String msg, Long count, List<T> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public LayuiTableModel() {
    }
}
