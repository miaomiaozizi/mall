/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: AreaJson
 * Author: Zi
 * Date: 2019/4/17 16:23
 * Description: areajson模型
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.model;

/**
 * areajson模型
 *
 * @author Zi
 * @create 2019/4/17
 * @since 1.0.0
 */
public class AreaJson {
    private Integer id;
    private String value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public AreaJson(Integer id, String value) {
        this.id = id;
        this.value = value;
    }

    public AreaJson() {
    }
}
