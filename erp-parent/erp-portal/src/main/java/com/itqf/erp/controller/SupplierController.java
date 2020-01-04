package com.itqf.erp.controller;

import com.itqf.erp.pojo.Supplier;
import com.itqf.erp.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 飞鸟
 * @date 2019/7/16 - 9:40
 */
@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private ISupplierService supplierService;

    @RequestMapping("/list")
    public List<Supplier> list(Supplier supplier){
       return supplierService.list(supplier);
    }

    @RequestMapping("/get")
    public Supplier get(Integer uuid){
        return supplierService.get(uuid);
    }
}
