package com.itqf.erp.mapper;

import com.itqf.erp.pojo.Dep;
import com.itqf.erp.pojo.DepExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepMapper {
    int countByExample(DepExample example);

    int deleteByExample(DepExample example);

    int deleteByPrimaryKey(Integer uuid);

    int insert(Dep record);

    int insertSelective(Dep record);

    List<Dep> selectByExample(DepExample example);

    Dep selectByPrimaryKey(Integer uuid);

    int updateByExampleSelective(@Param("record") Dep record, @Param("example") DepExample example);

    int updateByExample(@Param("record") Dep record, @Param("example") DepExample example);

    int updateByPrimaryKeySelective(Dep record);

    int updateByPrimaryKey(Dep record);
}