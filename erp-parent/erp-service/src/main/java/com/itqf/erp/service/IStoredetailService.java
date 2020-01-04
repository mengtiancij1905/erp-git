package com.itqf.erp.service;

import com.itqf.erp.pojo.EasyUIDataGrid;
import com.itqf.erp.pojo.ErpResult;
import com.itqf.erp.pojo.Storedetail;

import java.util.Map;

/**
 * @author 飞鸟
 * @date 2019/7/18 - 10:39
 */
public interface IStoredetailService {
    /**
     * 搜索库存消息
     * @param storedetail 条件
     * @param page
     * @param rows
     * @return
     */
    EasyUIDataGrid<Storedetail> search(Storedetail storedetail, int page, int rows);

    /**
     * 显示预警库存
     * @return
     */
    EasyUIDataGrid<Map> storeAlertList();

    /**
     * 发送库存预警邮件
     * @return
     */
    ErpResult sendAlertMail();
}
