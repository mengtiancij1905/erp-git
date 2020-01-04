package com.itqf.erp.mapper;

import com.itqf.erp.pojo.Storeoper;
import com.itqf.erp.pojo.StoreoperExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreoperMapper {
    int countByExample(StoreoperExample example);

    int deleteByExample(StoreoperExample example);

    int deleteByPrimaryKey(Integer uuid);

    int insert(Storeoper record);

    int insertSelective(Storeoper record);

    List<Storeoper> selectByExample(StoreoperExample example);

    Storeoper selectByPrimaryKey(Integer uuid);

    int updateByExampleSelective(@Param("record") Storeoper record, @Param("example") StoreoperExample example);

    int updateByExample(@Param("record") Storeoper record, @Param("example") StoreoperExample example);

    int updateByPrimaryKeySelective(Storeoper record);

    int updateByPrimaryKey(Storeoper record);
}