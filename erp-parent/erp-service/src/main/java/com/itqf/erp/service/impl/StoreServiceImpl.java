package com.itqf.erp.service.impl;

import com.itqf.erp.mapper.StoreMapper;
import com.itqf.erp.pojo.Store;
import com.itqf.erp.pojo.StoreExample;
import com.itqf.erp.service.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 飞鸟
 * @date 2019/7/17 - 14:31
 */
@Service
public class StoreServiceImpl implements IStoreService {
    @Autowired
    private StoreMapper storeMapper;

    @Override
    public List<Store> list(Integer empuuid) {
        StoreExample example = new StoreExample();
        StoreExample.Criteria criteria = example.createCriteria();
        criteria.andEmpuuidEqualTo(empuuid);

        List<Store> stores = storeMapper.selectByExample(example);
        return stores;
    }

    @Override
    public Store get(Integer uuid) {
        return storeMapper.selectByPrimaryKey(uuid);
    }

    @Override
    public List<Store> allList() {
        return storeMapper.selectByExample(null);
    }
}