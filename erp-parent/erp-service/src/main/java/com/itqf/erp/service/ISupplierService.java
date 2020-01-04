package com.itqf.erp.service;

import com.itqf.erp.pojo.Supplier;

import java.util.List;

/**
 * @author 飞鸟
 * @date 2019/7/16 - 9:42
 */
public interface ISupplierService {
    /**
     * 返回所有供应商或客户
     * @return
     */
    List<Supplier> list(Supplier supplier);

    /**
     * 根据编号查询供应商对象
     * @param uuid
     * @return
     */
    Supplier get(Integer uuid);
}
