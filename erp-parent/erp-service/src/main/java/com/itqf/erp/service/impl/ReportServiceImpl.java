package com.itqf.erp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itqf.erp.mapper.ReportMapper;
import com.itqf.erp.pojo.EasyUIDataGrid;
import com.itqf.erp.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author 飞鸟
 * @date 2019/7/18 - 14:29
 */
@Service
public class ReportServiceImpl implements IReportService {
    @Autowired
    private ReportMapper reportMapper;

    @Override
    public EasyUIDataGrid<Map> orderReport(Date begin, Date end, int page, int rows) {
        PageHelper.startPage(page, rows);

        List<Map> list = reportMapper.getTotalMoneyByOrderType(begin, end);

        PageInfo<Map> pageInfo = new PageInfo<>(list);

        EasyUIDataGrid<Map> datagrid = new EasyUIDataGrid<>();
        datagrid.setRows(list);
        datagrid.setTotal(pageInfo.getTotal());

        return datagrid;
    }

    @Override
    public EasyUIDataGrid<Map> trendReport(Integer year) {
        if(year==null){
            Calendar calendar= Calendar.getInstance();
            calendar.setTime(new Date());
            year = calendar.get(Calendar.YEAR);
        }
        List<Map> list = new ArrayList<>();
        for(int i=1; i<=12;i++){
            Map<String, Object> map = new HashMap<>();
            map.put("month",i+"月份");
            map.put("money", reportMapper.getTotalMoneyByYearAndMonth(year, i));
            list.add(map);
        }

        EasyUIDataGrid<Map> dataGrid = new EasyUIDataGrid<>();
        dataGrid.setTotal(list.size());
        dataGrid.setRows(list);

        return dataGrid;
    }
}
