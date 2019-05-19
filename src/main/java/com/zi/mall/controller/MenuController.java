/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: MenuController
 * Author: Zi
 * Date: 2019/4/20 16:46
 * Description: 菜单控制器
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.controller;

import com.zi.mall.domain.Available;
import com.zi.mall.model.TreeNode;
import com.zi.mall.service.MenuService;
import com.zi.mall.vo.AvailableVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单控制器
 *
 * @author Zi
 * @create 2019/4/20
 * @since 1.0.0
 */
@Controller
public class MenuController {
    @Autowired
    private MenuService menuService;

    @ResponseBody
    @RequestMapping("/loadAllMenu")
    public List<TreeNode> loadAllMenu() {
        List<Available> availables = menuService.queryMenuByUserId(new AvailableVo(), 1);
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        for (Available available : availables) {
            treeNodes.add(new TreeNode(available.getId(), available.getPid(), available.getName(), available.getIcon(), available.getHref(), available.getParent().equals("1") ? true : false));
        }
        return builder(treeNodes, 0);
    }

    private static List<TreeNode> builder(List<TreeNode> treeNodes, Integer topRootPid) {
        List<TreeNode> nodes = new ArrayList<>();
        for (TreeNode n1 : treeNodes) {
            if (n1.getPid().equals(topRootPid)) {
                nodes.add(n1);
            }
            for (TreeNode n2 : treeNodes) {
                // 说明n2是n1的子节点
                if (n1.getId().equals(n2.getPid())) {
                    n1.getChildren().add(n2);
                }
            }
        }
        return nodes;
    }
}
