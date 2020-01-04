package com.itqf.erp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itqf.erp.mapper.StoreoperMapper;
import com.itqf.erp.pojo.*;
import com.itqf.erp.service.IStoreoperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 飞鸟
 * @date 2019/7/18 - 11:56
 */
@Service
public class StoreoperServiceImpl implements IStoreoperService {
    @Autowired
    private StoreoperMapper storeoperMapper;

    @Override
    public EasyUIDataGrid<Storeoper> search(Storeoper storeoper, int page, int rows) {
        PageHelper.startPage(page, rows);

        StoreoperExample example = new StoreoperExample();
        StoreoperExample.Criteria criteria = example.createCriteria();
        if(storeoper!=null){
            //设置查询条件

        }
        List<Storeoper> list = storeoperMapper.selectByExample(example);

        PageInfo<Storeoper> pageInfo = new PageInfo<>(list);
        EasyUIDataGrid<Storeoper> dataGrid = new EasyUIDataGrid<>();
        dataGrid.setRows(list);
        dataGrid.setTotal(pageInfo.getTotal());

        return dataGrid;
    }
}
