package com.itqf.erp.controller;

import com.itqf.erp.pojo.Menu;
import com.itqf.erp.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 飞鸟
 * @date 2019/7/15 - 14:39
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private IMenuService menuService;

    @RequestMapping("/showmenu")
    public Menu showMenu(){
        /*
        Menu menu = new Menu();
        menu.setIcon("icon-sys");
        menu.setMenuid("0");
        menu.setMenuname("系统菜单");

        menu.setUrl("");

        List<Menu> list = new ArrayList<>();
        Menu m1 = new Menu();
        m1.setMenuid("101");
        m1.setUrl("");
        m1.setIcon("icon-sys");
        m1.setMenuname("新闻");
        List<Menu> list11 = new ArrayList<>();

        Menu m11 = new Menu();
        m11.setMenuid("1011");
        m11.setUrl("");
        m11.setIcon("icon-sys");
        m11.setMenuname("国际新闻");
        Menu m12 = new Menu();
        m12.setMenuid("1011");
        m12.setUrl("");
        m12.setIcon("icon-sys");
        m12.setMenuname("国内新闻");
        list11.add(m11);
        list11.add(m12);

        List<Menu> list22 = new ArrayList<>();

        Menu m21 = new Menu();
        m21.setMenuid("1011");
        m21.setUrl("");
        m21.setIcon("icon-sys");
        m21.setMenuname("上海新闻");
        Menu m22 = new Menu();
        m22.setMenuid("1011");
        m22.setUrl("");
        m22.setIcon("icon-sys");
        m22.setMenuname("北京新闻");
        list22.add(m21);
        list22.add(m22);
        m12.setMenus(list22);



        m1.setMenus(list11);


        list.add(m1);
        Menu m2 = new Menu();
        m2.setMenuid("102");
        m2.setUrl("");
        m2.setIcon("icon-sys");
        m2.setMenuname("音乐");
        list.add(m2);

        menu.setMenus(list);
        */
        Menu menu = menuService.selectTopMenu();

        return menu;
    }
}
