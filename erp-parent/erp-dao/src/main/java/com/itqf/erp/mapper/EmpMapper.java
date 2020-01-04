package com.itqf.erp.mapper;

import com.itqf.erp.pojo.Emp;
import com.itqf.erp.pojo.EmpExample;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface EmpMapper {
    int countByExample(EmpExample example);

    int deleteByExample(EmpExample example);

    int deleteByPrimaryKey(Integer uuid);

    int insert(Emp record);

    int insertSelective(Emp record);

    List<Emp> selectByExample(EmpExample example);

    /**
     * 自定义的搜索查询
     * @param emp
     * @param birthday2
     * @return
     */
    List<Emp> selectJoinByExample(@Param("emp")Emp emp, @Param("birthday2")Date birthday2);

    Emp selectByPrimaryKey(Integer uuid);

    int updateByExampleSelective(@Param("record") Emp record, @Param("example") EmpExample example);

    int updateByExample(@Param("record") Emp record, @Param("example") EmpExample example);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);
}