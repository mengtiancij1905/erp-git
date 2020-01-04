package com.itqf.erp.service;

import com.itqf.erp.pojo.EasyUIDataGrid;

import java.util.Date;
import java.util.Map;

/**
 * @author 飞鸟
 * @date 2019/7/18 - 14:28
 */
public interface IReportService {
    /**
     * 根据时间段获取对应商品类型的销售额
     * @param begin
     * @param end
     * @return
     */
    EasyUIDataGrid<Map> orderReport(Date begin, Date end, int page, int rows);

    /**
     * 根据年份查询
     * @param year
     * @return
     */
    EasyUIDataGrid<Map> trendReport(Integer year);
}
