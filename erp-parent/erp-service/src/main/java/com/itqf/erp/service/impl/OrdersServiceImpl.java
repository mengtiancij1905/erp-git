package com.itqf.erp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itqf.erp.mapper.OrderdetailMapper;
import com.itqf.erp.mapper.OrdersMapper;
import com.itqf.erp.mapper.StoredetailMapper;
import com.itqf.erp.mapper.StoreoperMapper;
import com.itqf.erp.pojo.*;
import com.itqf.erp.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author 飞鸟
 * @date 2019/7/16 - 10:46
 */
@Service
public class OrdersServiceImpl implements IOrdersService {
    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private OrderdetailMapper orderdetailMapper ;
    @Autowired
    private StoredetailMapper storedetailMapper;
    @Autowired
    private StoreoperMapper storeoperMapper;

    @Override
    public void add(Orders orders, List<Orderdetail> orderdetails) {
        //1.先向订单表插入数据
        //主要：插入订单数据之后 ，需要获取订单编号
        ordersMapper.insertSelective(orders);

        Integer ordersuuid = orders.getUuid();

        //2.向订单明细表插入数据
        for(Orderdetail od : orderdetails){
            //补充数据：
            od.setState("0");//未入库
            od.setOrdersuuid(ordersuuid);
            orderdetailMapper.insertSelective(od);
        }
    }

    @Override
    public EasyUIDataGrid<Orders> search(Orders orders, int page, int rows) {
        PageHelper.startPage(page, rows);
        OrdersExample example = new OrdersExample();
        //设置条件
        if(orders!=null){
            OrdersExample.Criteria criteria = example.createCriteria();
            //1.根据状态查询
            if(orders.getState()!=null && orders.getState().trim()!=""){
                criteria.andStateEqualTo(orders.getState());
            }
        }

        List<Orders> list = ordersMapper.selectByExample(example);//Page extends ArrayList

        //Page {count=true, pageNum=1, pageSize=10, startRow=0, endRow=10
        System.out.println(list);//?list是什么类的数据？   {orders,orders,orders}
        PageInfo<Orders> pageInfo = new PageInfo<>(list);

        EasyUIDataGrid<Orders> dataGrid = new EasyUIDataGrid<>();
        dataGrid.setRows(list);
        dataGrid.setTotal(pageInfo.getTotal());

        return dataGrid;
    }

    @Override
    public EasyUIDataGrid<Orderdetail> orderdetail(Integer uuid) {
        OrderdetailExample example = new OrderdetailExample();
        OrderdetailExample.Criteria criteria = example.createCriteria();
        criteria.andOrdersuuidEqualTo(uuid);
        List<Orderdetail> orderdetails = orderdetailMapper.selectByExample(example);
        EasyUIDataGrid<Orderdetail> dataGrid = new EasyUIDataGrid<>();
        dataGrid.setTotal(orderdetails.size());
        dataGrid.setRows(orderdetails);
        return dataGrid;
    }

    @Override
    public ErpResult doCheck(Integer uuid, Integer empuuid) {
        //审核订单
        Orders orders = ordersMapper.selectByPrimaryKey(uuid);

        //1.修改订单状态： state=1
        orders.setState("1");//已审核

        //2.添加审核人和审核时间
        orders.setChecker(empuuid);
        orders.setChecktime(new Date());
        ordersMapper.updateByPrimaryKeySelective(orders);
        return ErpResult.ok("订单审核成功！");
    }

    @Override
    public ErpResult doStart(Integer uuid, Integer empuuid) {
        //审核订单
        Orders orders = ordersMapper.selectByPrimaryKey(uuid);

        //1.修改订单状态： state=2
        orders.setState("2");//已采购

        //2.添加审核人和审核时间
        orders.setStarter(empuuid);
        orders.setStarttime(new Date());
        ordersMapper.updateByPrimaryKeySelective(orders);
        return ErpResult.ok("订单采购成功！");
    }

    @Override
    public ErpResult doInstore(Integer orderdetailuuid, Integer storeuuid, Integer empuuid) {
        /*
         1、修改订单明细表（orderdetail）
            endtime:记录入库时间
            ender：记录库管员
            storeuuid:该商品入到那个仓库中了
            state:该商品的入库状态
        */

        Orderdetail orderdetail = orderdetailMapper.selectByPrimaryKey(orderdetailuuid);
        orderdetail.setEnder(empuuid);//库管员编号
        orderdetail.setEndtime(new Date());//入库日期
        orderdetail.setStoreuuid(storeuuid);//仓库编号
        orderdetail.setState("1");//入库状态

        orderdetailMapper.updateByPrimaryKeySelective(orderdetail);

        /*
        2、修改仓库明细（storedetail）
            2.1 判断当前仓库中是否已经存在该商品了
            2.2 如果存在则是加数量
            2.3 如果不存在则添加库存
        */
        StoredetailExample storedetailExample = new StoredetailExample();
        StoredetailExample.Criteria criteria = storedetailExample.createCriteria();
        criteria.andGoodsuuidEqualTo(orderdetail.getGoodsuuid());//设置商品编号
        criteria.andStoreuuidEqualTo(storeuuid);
        List<Storedetail> storedetails = storedetailMapper.selectByExample(storedetailExample);
        if(storedetails.size()>0){
            //该仓库中存在要入库的商品
            Storedetail sd = storedetails.get(0);
            //修改对应库存
            sd.setNum(sd.getNum()+orderdetail.getNum());
            storedetailMapper.updateByPrimaryKeySelective(sd);
        }else{
            //不存在该商品
            Storedetail sd = new Storedetail();
            sd.setNum(orderdetail.getNum());
            sd.setGoodsuuid(orderdetail.getGoodsuuid());
            sd.setStoreuuid(storeuuid);
            storedetailMapper.insert(sd);
        }

        /*
        3、添加库存操作记录(storeoper)
            将当前的操作记录下来
        */
        Storeoper storeoper = new Storeoper();
        storeoper.setEmpuuid(empuuid);
        storeoper.setGoodsuuid(orderdetail.getGoodsuuid());
        storeoper.setNum(orderdetail.getNum());
        storeoper.setOpertime(new Date());
        storeoper.setStoreuuid(storeuuid);
        storeoper.setType("1");
        storeoperMapper.insert(storeoper);

        /*
        4、修改订单状态
            判断当前订单下的所有明细是否都已入库，如果都已入库则修改状态state=3
         */
        //查询该订单对应明细表中是否存在state=0的记录
        OrderdetailExample orderdetailExample = new OrderdetailExample();
        OrderdetailExample.Criteria criteria1 = orderdetailExample.createCriteria();
        criteria1.andOrdersuuidEqualTo(orderdetail.getOrdersuuid());
        criteria1.andStateEqualTo("0");

        List<Orderdetail> orderdetails = orderdetailMapper.selectByExample(orderdetailExample);
        if(orderdetails.size()==0){
            //都已入库，则需要修改订单状态
            Orders orders = new Orders();
            orders.setUuid(orderdetail.getOrdersuuid());
            orders.setState("3");
            orders.setEndtime(new Date());
            orders.setEnder(empuuid);
            ordersMapper.updateByPrimaryKeySelective(orders);
        }

        return ErpResult.ok("入库成功！");
    }
}
