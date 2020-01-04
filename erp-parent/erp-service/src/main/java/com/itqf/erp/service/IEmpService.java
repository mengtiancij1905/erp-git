package com.itqf.erp.service;

import com.itqf.erp.pojo.EasyUIDataGrid;
import com.itqf.erp.pojo.Emp;
import com.itqf.erp.pojo.ErpResult;

import java.util.Date;

/**
 * @author 飞鸟
 * @date 2019/7/10 - 14:14
 */
public interface IEmpService {
    /**
     * 分页查询
     * @param page 当前页码
     * @param rows 每一页大小
     * @return 当前页数据
     */
    EasyUIDataGrid<Emp> search(Emp emp, int page, int rows);

    /**
     * 分页搜索
     * @param emp
     * @param birthday2
     * @param page
     * @param rows
     * @return
     */
    EasyUIDataGrid<Emp> search(Emp emp, Date birthday2, int page, int rows);

    /**
     * 增加新用户
     * @param emp
     * @return
     */
    ErpResult add(Emp emp);

    /**
     * 根据编号查询
     * @param uuid
     * @return
     */
    Emp get(Integer uuid);

    /**
     * 验证用户名是否存在
     * @param username
     * @return
     */
    Emp checkUserName(String username);
}
