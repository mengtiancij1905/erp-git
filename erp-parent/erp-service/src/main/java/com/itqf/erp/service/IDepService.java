package com.itqf.erp.service;

import com.itqf.erp.pojo.Dep;
import com.itqf.erp.pojo.EasyUIDataGrid;

import java.util.List;

/**
 * @author 飞鸟
 * @date 2019/7/8 - 16:41
 */
public interface IDepService {
    /**
     * 查询所有dep
     * @return
     */
    public List<Dep> list();

    /**
     * 分页查询
     * @param page 当前页码
     * @param rows 每一页大小
     * @return 当前页数据
     */
    EasyUIDataGrid<Dep> search(Dep dep, int page, int rows);

    /**
     * 添加新部门
     * @param dep
     * @return 影响的行数
     */
    int add(Dep dep);

    /**
     * 删除部门
     * @param uuid 部门编号
     * @return 影响的行数
     */
    int delete(Integer uuid);

    /**
     * 根据编号查询部门信息
     * @param uuid
     * @return
     */
    Dep get(Integer uuid);

    /**
     * 修改部门
     * @param dep
     * @return
     */
    int update(Dep dep);
}
