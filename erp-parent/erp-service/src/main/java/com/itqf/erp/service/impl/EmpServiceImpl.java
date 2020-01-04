package com.itqf.erp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itqf.erp.mapper.EmpMapper;
import com.itqf.erp.pojo.EasyUIDataGrid;
import com.itqf.erp.pojo.Emp;
import com.itqf.erp.pojo.EmpExample;
import com.itqf.erp.pojo.ErpResult;
import com.itqf.erp.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author 飞鸟
 * @date 2019/7/10 - 14:15
 */
@Service
public class EmpServiceImpl implements IEmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public EasyUIDataGrid<Emp> search(Emp emp, int page, int rows) {
        //开启分页
        PageHelper.startPage(page, rows);//在之后执行的SELECT语句中自动加上limit (page-1)*rows, rows
        //JPA
        //1、创建条件
        EmpExample example = new EmpExample();

        //设置查询条件
        if(emp!=null){
            //TODO 未完成
        }
        //返回当前页的数据
        List<Emp> list = empMapper.selectJoinByExample(null,null);

        PageInfo<Emp> pageInfo = new PageInfo<>(list);
        EasyUIDataGrid<Emp> dataGrid = new EasyUIDataGrid<Emp>();
        dataGrid.setTotal(pageInfo.getTotal());
        dataGrid.setRows(list);
        return dataGrid;
    }

    @Override
    public EasyUIDataGrid<Emp> search(Emp emp, Date birthday2, int page, int rows) {
        //开启分页
        PageHelper.startPage(page, rows);//在之后执行的SELECT语句中自动加上limit (page-1)*rows, rows
        //JPA
        //1、创建条件
        EmpExample example = new EmpExample();

        //设置查询条件
        if(emp!=null){




        }
        //返回当前页的数据
        List<Emp> list = empMapper.selectJoinByExample(emp, birthday2);

        PageInfo<Emp> pageInfo = new PageInfo<>(list);
        EasyUIDataGrid<Emp> dataGrid = new EasyUIDataGrid<Emp>();
        dataGrid.setTotal(pageInfo.getTotal());
        dataGrid.setRows(list);
        return dataGrid;
    }

    @Override
    public ErpResult add(Emp emp) {
        //emp对象的uuid是空的 瞬时对象
        int ret = empMapper.insertSelective(emp);
        //emp对象中的uuid就有值了  持久对象

        return ErpResult.ok("员工添加成功", emp);
    }

    @Override
    public Emp get(Integer uuid) {
        return empMapper.selectByPrimaryKey(uuid);
    }

    @Override
    public Emp checkUserName(String username) {
        EmpExample example = new EmpExample();
        EmpExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<Emp> emps = empMapper.selectByExample(example);
        return emps.size()>0?emps.get(0):null;
    }
}
