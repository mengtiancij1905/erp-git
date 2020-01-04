package com.itqf.erp.service.impl;

import com.itqf.erp.mapper.SupplierMapper;
import com.itqf.erp.pojo.Supplier;
import com.itqf.erp.pojo.SupplierExample;
import com.itqf.erp.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 飞鸟
 * @date 2019/7/16 - 9:45
 */
@Service
public class SupplierServiceImpl implements ISupplierService {
    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public List<Supplier> list(Supplier supplier) {
        SupplierExample example = new SupplierExample();
        if(supplier!=null){
            SupplierExample.Criteria criteria = example.createCriteria();
            if(supplier.getType()!=null && supplier.getType().trim()!=""){
                criteria.andTypeEqualTo(supplier.getType());
            }
            //省略其他条件。。。
        }

        List<Supplier> list = supplierMapper.selectByExample(example);
        return list;
    }

    @Override
    public Supplier get(Integer uuid) {
        return supplierMapper.selectByPrimaryKey(uuid);
    }
}
