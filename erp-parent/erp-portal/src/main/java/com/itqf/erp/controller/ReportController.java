package com.itqf.erp.controller;

import com.itqf.erp.pojo.EasyUIDataGrid;
import com.itqf.erp.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

/**
 * @author 飞鸟
 * @date 2019/7/18 - 14:25
 */
@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private IReportService reportService;

    @RequestMapping(value = "/orderReport",method = RequestMethod.POST)
    public EasyUIDataGrid<Map>  orderReport(Date begin, Date end, @RequestParam(value="page", defaultValue = "1") int page, @RequestParam(value="rows", defaultValue = "10") int rows){
        return reportService.orderReport(begin, end, page, rows);
    }

    @RequestMapping("/trendReport")
    public EasyUIDataGrid<Map> trendReport(Integer year){
        return reportService.trendReport(year);
    }
}
