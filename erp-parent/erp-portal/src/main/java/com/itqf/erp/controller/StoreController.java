package com.itqf.erp.controller;

import com.itqf.erp.pojo.Emp;
import com.itqf.erp.pojo.Store;
import com.itqf.erp.service.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 飞鸟
 * @date 2019/7/17 - 14:28
 */
@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private IStoreService storeService;

    @RequestMapping("/list")
    public List<Store> list(HttpSession session){
        Emp emp = (Emp) session.getAttribute("user");
        if(emp==null){
            return null;
        }else{
            return storeService.list(emp.getUuid());
        }
    }

    @RequestMapping("/allList")
    public List<Store> allList(HttpSession session){
        return storeService.allList();
    }


    @RequestMapping("/get")
    public Store get(Integer uuid){
        return storeService.get(uuid);
    }
}
