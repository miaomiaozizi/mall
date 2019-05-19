/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: TreeNode
 * Author: Zi
 * Date: 2019/4/20 17:42
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author Zi
 * @create 2019/4/20
 * @since 1.0.0
 */
public class TreeNode {
    private Integer id;
    @JsonProperty("pId")
    private Integer pid;
    private String name;
    private String icon;
    private String href;
    private Boolean spread;
    private List<TreeNode> children = new ArrayList<>();
    //zTree的加的属性
    private Boolean open;
    private Boolean isParent;

    //zTree的复选树属性
    private Boolean checked;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Boolean getSpread() {
        return spread;
    }

    public void setSpread(Boolean spread) {
        this.spread = spread;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public Boolean getParent() {
        return isParent;
    }

    public void setParent(Boolean parent) {
        isParent = parent;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
    /**
     * zTree的复选树的构造方法
     * @param id
     * @param pid
     * @param name
     * @param open
     * @param isParent
     * @param checked
     */
    public TreeNode(Integer id, Integer pid, String name, Boolean open, Boolean isParent, Boolean checked) {
        super();
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.open = open;
        this.isParent = isParent;
        this.checked = checked;
    }


    /**
     * zTree构造对象
     * @param id
     * @param pid
     * @param name
     * @param open
     * @param isParent
     */
    public TreeNode(Integer id, Integer pid, String name, Boolean open, Boolean isParent) {
        super();
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.open = open;
        this.isParent = isParent;
    }


    /**
     * 主页的导航菜单使用的构造方法
     * @param id
     * @param pid
     * @param name
     * @param icon
     * @param href
     * @param spread
     */
    public TreeNode(Integer id, Integer pid, String name, String icon, String href, Boolean spread) {
        super();
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.icon = icon;
        this.href = href;
        this.spread = spread;
    }

}
