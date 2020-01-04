package com.itqf.erp.service.impl;

import com.itqf.erp.mapper.MenuMapper;
import com.itqf.erp.pojo.Menu;
import com.itqf.erp.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 飞鸟
 * @date 2019/7/15 - 15:32
 */
@Service
public class MenuServiceImpl implements IMenuService {
    @Autowired
    private MenuMapper menuMapper ;

    @Override
    public Menu selectTopMenu() {
        return menuMapper.selectByPrimaryKey("0");
    }
}
