package com.itqf.erp.service;

import com.itqf.erp.pojo.EasyUIDataGrid;
import com.itqf.erp.pojo.Storeoper;

/**
 * @author 飞鸟
 * @date 2019/7/18 - 11:55
 */
public interface IStoreoperService {
    /**
     * 实现库存操作记录的搜索
     * @param storeoper
     * @param page
     * @param rows
     * @return
     */
    EasyUIDataGrid<Storeoper> search(Storeoper storeoper, int page, int rows);
}
