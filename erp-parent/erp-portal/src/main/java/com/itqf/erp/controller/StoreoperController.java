package com.itqf.erp.controller;

import com.itqf.erp.pojo.EasyUIDataGrid;
import com.itqf.erp.pojo.Storeoper;
import com.itqf.erp.service.IStoreoperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 飞鸟
 * @date 2019/7/18 - 11:54
 */
@RestController
@RequestMapping("/storeoper")
public class StoreoperController {
    @Autowired
    private IStoreoperService storeoperService;

    @RequestMapping("/search")
    public EasyUIDataGrid<Storeoper> search(Storeoper storeoper, @RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "rows", defaultValue = "10") int rows) {
        return storeoperService.search(storeoper, page, rows);
    }
}
