package com.itqf.erp.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 飞鸟
 * @date 2019/7/18 - 14:31
 */
public interface ReportMapper {
    List<Map> getTotalMoneyByOrderType(@Param("begin") Date begin, @Param("end") Date end);

    double getTotalMoneyByYearAndMonth(@Param("year") Integer year, @Param("month") Integer month);
}
