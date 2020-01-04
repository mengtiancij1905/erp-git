package com.itqf.erp.mapper;

import com.itqf.erp.pojo.Storedetail;
import com.itqf.erp.pojo.StoredetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StoredetailMapper {
    int countByExample(StoredetailExample example);

    int deleteByExample(StoredetailExample example);

    int deleteByPrimaryKey(Integer uuid);

    int insert(Storedetail record);

    int insertSelective(Storedetail record);

    List<Storedetail> selectByExample(StoredetailExample example);

    Storedetail selectByPrimaryKey(Integer uuid);

    int updateByExampleSelective(@Param("record") Storedetail record, @Param("example") StoredetailExample example);

    int updateByExample(@Param("record") Storedetail record, @Param("example") StoredetailExample example);

    int updateByPrimaryKeySelective(Storedetail record);

    int updateByPrimaryKey(Storedetail record);

    List<Map> storeAlertList();
}