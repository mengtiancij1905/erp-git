package com.itqf.erp.service.impl;

import com.itqf.erp.mapper.GoodsMapper;
import com.itqf.erp.pojo.Goods;
import com.itqf.erp.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 飞鸟
 * @date 2019/7/15 - 17:13
 */
@Service
public class GoodsServiceImpl implements IGoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public List<Goods> list() {
        return goodsMapper.selectByExample(null);
    }

    public Goods get(Integer uuid){
        return goodsMapper.selectByPrimaryKey(uuid);
    }
}
