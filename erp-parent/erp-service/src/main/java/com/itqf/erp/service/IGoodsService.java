package com.itqf.erp.service;

import com.itqf.erp.pojo.Goods;

import java.util.List;

/**
 * @author 飞鸟
 * @date 2019/7/15 - 17:12
 */
public interface IGoodsService {
    List<Goods> list();

    Goods get(Integer uuid);
}
