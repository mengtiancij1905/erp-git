package com.itqf.erp.service;

import com.itqf.erp.pojo.Menu;

/**
 * @author 飞鸟
 * @date 2019/7/15 - 15:31
 */
public interface IMenuService {
    /**
     * 显示顶级菜单
     * @return
     */
    Menu selectTopMenu();
}
