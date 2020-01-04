package com.itqf.erp.service;

import com.itqf.erp.pojo.EasyUIDataGrid;
import com.itqf.erp.pojo.ErpResult;
import com.itqf.erp.pojo.Orderdetail;
import com.itqf.erp.pojo.Orders;

import java.util.List;

/**
 * @author 飞鸟
 * @date 2019/7/16 - 10:46
 */
public interface IOrdersService {
    /**
     * 生成采购订单
     * @param orders
     * @param orderdetails
     */
    void add(Orders orders, List<Orderdetail> orderdetails);

    /**
     * 根据条件搜索，返回当前分页数据
     * @param orders
     * @param page
     * @param rows
     * @return
     */
    EasyUIDataGrid<Orders> search(Orders orders, int page, int rows);

    /**
     * 返回当前订单的所有订单明细
     * @param uuid
     * @return
     */
    EasyUIDataGrid<Orderdetail> orderdetail(Integer uuid);

    /**
     * 订单审核
     * @param uuid
     * @return
     */
    ErpResult doCheck(Integer uuid, Integer empuuid);

    /**
     * 订单确认
     * @param uuid
     * @param uuid1
     * @return
     */
    ErpResult doStart(Integer uuid, Integer uuid1);

    /**
     * 实现入库过程
     * @param orderdetailuuid 订单明细编号
     * @param storeuuid 仓库编号
     * @param empuuid  库管员编号
     * @return
     */
    ErpResult doInstore(Integer orderdetailuuid, Integer storeuuid, Integer empuuid);
}
