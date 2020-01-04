package com.itqf.erp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itqf.erp.mapper.DepMapper;
import com.itqf.erp.pojo.Dep;
import com.itqf.erp.pojo.DepExample;
import com.itqf.erp.pojo.EasyUIDataGrid;
import com.itqf.erp.service.IDepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 飞鸟
 * @date 2019/7/8 - 16:43
 */
@Service
public class DepServiceImpl implements IDepService {
    @Autowired
    private DepMapper depMapper;

    //spring5中默认支持servlet3.0，异步响应

    @Override
    public List<Dep> list() {
        return depMapper.selectByExample(null);
    }

    @Override
    public EasyUIDataGrid<Dep> search(Dep dep, int page, int rows) {
        //开启分页
        PageHelper.startPage(page, rows);//在之后执行的SELECT语句中自动加上limit (page-1)*rows, rows

        //1、创建条件
        DepExample example = new DepExample();

        //设置查询条件
        if(dep!=null){
            //2.创建约束对象
            DepExample.Criteria criteria = example.createCriteria();
            //3.设置约束条件
            //3.1
            if(dep.getDepName()!=null && dep.getDepName().trim()!=""){
                //depName like '%depName%'
                criteria.andDepNameLike("%"+dep.getDepName()+"%");//depName like '%depName%'
            }

            if(dep.getTele()!=null && dep.getTele().trim()!=""){
                criteria.andTeleLike("%"+dep.getTele()+"%");
            }
        }

        //返回当前页的数据
        List<Dep> list = depMapper.selectByExample(example);//select * from dep where uuid=1

        PageInfo<Dep> pageInfo = new PageInfo<>(list);
        EasyUIDataGrid<Dep> dataGrid = new EasyUIDataGrid<Dep>();
        dataGrid.setTotal(pageInfo.getTotal());
        dataGrid.setRows(list);
        return dataGrid;
    }

    @Override
    public int add(Dep dep) {
        return depMapper.insertSelective(dep);
    }

    @Override
    public int delete(Integer uuid) {
        return depMapper.deleteByPrimaryKey(uuid);
    }

    @Override
    public Dep get(Integer uuid) {
        return depMapper.selectByPrimaryKey(uuid);
    }

    @Override
    public int update(Dep dep) {
        return depMapper.updateByPrimaryKeySelective(dep);
    }
}
