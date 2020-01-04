package com.itqf.erp.controller;

import com.itqf.erp.pojo.Goods;
import com.itqf.erp.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 飞鸟
 * @date 2019/7/15 - 17:11
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private IGoodsService goodsService;

    @RequestMapping("/list")
    public List<Goods> list(){
        return goodsService.list();
    }

    @RequestMapping("/get")
    public Goods get(Integer uuid){
     return goodsService.get(uuid);
    }
}
