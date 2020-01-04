package com.itqf.erp.controller;

import com.itqf.erp.pojo.*;
import com.itqf.erp.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 飞鸟
 * @date 2019/7/16 - 10:36
 */
@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService ordersService;

    /*
    {
        "supplieruuid":"7",
        "json":"[{\"num\":1,\"money\":\"2.34\",\"goodsuuid\":\"1\",\"goodsname\":\"水蜜桃\",\"price\":\"2.34\"},{\"num\":1,\"money\":\"3.88\",\"goodsuuid\":\"5\",\"goodsname\":\"可比克\",\"price\":\"3.88\"}]"
     }

    Value Object:vo
    Entity/POJO:
    DTO:
     */
    @RequestMapping("/add")
    public ErpResult add(HttpSession session , @RequestBody OrdersForm ordersForm){
        //获取当前用户信息
        Emp emp = (Emp) session.getAttribute("user");
        if (emp != null) {
            //生成订单
            //1.订单对象
            Orders orders = new Orders();
            orders.setCreatetime(new Date());//下单时间
            orders.setType("1");//订单类型 1:采购订单   2：销售订单
            orders.setCreater(emp.getUuid());//下单员
            orders.setSupplieruuid(ordersForm.getSupplieruuid());

            //计算总价
            double totalMoney =0;
            for(Orderdetail od : ordersForm.getJson()){
               totalMoney += od.getMoney().doubleValue();
            }
            orders.setTotalmoney(new BigDecimal(totalMoney));
            orders.setState("0");

            //2.订单明细对象
            ordersService.add(orders, ordersForm.getJson());

            return ErpResult.ok("采购订单生成成功！");
        }else{
            return ErpResult.notOk("请登录....");
        }
    }

    @RequestMapping("/search")
    public EasyUIDataGrid<Orders> search(Orders orders, @RequestParam(value = "page", defaultValue = "1") int page ,@RequestParam(value = "rows", defaultValue = "10") int rows){
       return ordersService.search(orders, page, rows);
    }


    @RequestMapping("/orderdetail")
    public EasyUIDataGrid<Orderdetail> orderdetail(Integer uuid){
        return ordersService.orderdetail(uuid);
    }

    @RequestMapping("/doCheck")
    public ErpResult doCheck(Integer uuid,HttpSession session){
        Emp emp = (Emp) session.getAttribute("user");
        if(emp==null){
            return ErpResult.notOk("请登录。。。。");
        }

        return ordersService.doCheck(uuid, emp.getUuid());
    }

    @RequestMapping("/doStart")
    public ErpResult doStart(Integer uuid,HttpSession session){
        Emp emp = (Emp) session.getAttribute("user");
        if(emp==null){
            return ErpResult.notOk("请登录。。。。");
        }

        return ordersService.doStart(uuid, emp.getUuid());
    }

    @RequestMapping("/doInStore")
    public ErpResult doInstore(Integer id, Integer storeuuid, HttpSession session){
        Emp emp = (Emp) session.getAttribute("user");
        if(emp==null){
            return ErpResult.notOk("请登录。。。");
        }


        return ordersService.doInstore(id,storeuuid, emp.getUuid());

    }
}
