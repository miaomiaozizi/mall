/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: Result
 * Author: Zi
 * Date: 2019/4/17 16:49
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.vo;

import java.util.List;

/**
 *
 *
 * @author Zi
 * @create 2019/4/17
 * @since 1.0.0
 */
public class Result<T> {
    public Integer code;
    private String msg;
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

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Result() {
    }

    public Result(Integer code, String msg, List<T> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
public static Result ok(){
        return new Result(200,"ok",null);
}
public static Result error(){
        return new Result(500,"error",null);
}
}

