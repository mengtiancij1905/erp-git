package com.itqf.erp.controller;

import com.itqf.erp.pojo.EasyUIDataGrid;
import com.itqf.erp.pojo.ErpResult;
import com.itqf.erp.pojo.Storedetail;
import com.itqf.erp.service.IStoredetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author 飞鸟
 * @date 2019/7/18 - 10:37
 */
@RestController
@RequestMapping("/storedetail")
public class StoredetailController {

    @Autowired
    private IStoredetailService storedetailService;

    @RequestMapping("/search")
    public EasyUIDataGrid<Storedetail> search(Storedetail storedetail, @RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "rows", defaultValue = "10") int rows) {
       return storedetailService.search(storedetail, page, rows);
    }

    @RequestMapping("/storeAlertList")
    public EasyUIDataGrid<Map> storeAlertList(){
        return storedetailService.storeAlertList();
    }

    @RequestMapping("/sendAlertMail")
    public ErpResult sendAlertMail(){
        return storedetailService.sendAlertMail();
    }
}
