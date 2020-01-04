package com.itqf.erp.service;

import com.itqf.erp.pojo.Store;

import java.util.List;

/**
 * @author 飞鸟
 * @date 2019/7/17 - 14:31
 */
public interface IStoreService {
    /**
     * 返回当前用户管理的库存
     * @param empuuid
     * @return
     */
    public List<Store> list(Integer empuuid);

    Store get(Integer uuid);

    /**
     * 显示所有库存
     * @return
     */
    List<Store> allList();
}
