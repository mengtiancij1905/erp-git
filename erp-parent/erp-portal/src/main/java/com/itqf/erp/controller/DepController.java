package com.itqf.erp.controller;

import com.itqf.erp.pojo.Dep;
import com.itqf.erp.pojo.EasyUIDataGrid;
import com.itqf.erp.pojo.ErpResult;
import com.itqf.erp.service.IDepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 飞鸟
 * @date 2019/7/8 - 16:40
 */
@RestController
@RequestMapping("/dep")
public class DepController {
    //@Resource：按照名字，按照类型    jdk
    //@Autowired:按照类型，          spring
    @Autowired
    private IDepService depService;

    @RequestMapping("/list")
    @ResponseBody
    public List<Dep> list(){
        //jackson
        List<Dep> list = depService.list();

        return list;
    }

    @RequestMapping("/search")
    public EasyUIDataGrid<Dep> search(Dep dep, @RequestParam(value = "page",defaultValue = "1") int page, @RequestParam(value = "rows",defaultValue = "10") int rows){
        EasyUIDataGrid<Dep> dataGrid =  depService.search(dep, page, rows);
        return dataGrid;
    }

    @RequestMapping("/add")
    public ErpResult add(Dep dep){
        int retDep = depService.add(dep);
        if(retDep>0) {
            return ErpResult.ok("部门添加成功！");
        }else{
            return ErpResult.notOk();
        }
    }

    @RequestMapping("/delete")
    public ErpResult delete(Integer uuid){
        int retRows = depService.delete(uuid);
        if(retRows>0) {
            return ErpResult.ok("该部门删除成功！");
        }else{
            return ErpResult.notOk();
        }
    }

    @RequestMapping("/get")
    public Dep get(Integer uuid){
        return depService.get(uuid);
    }

    @RequestMapping("/update")
    public ErpResult update(Dep dep){
        int retDep = depService.update(dep);
        if(retDep>0) {
            return ErpResult.ok("部门修改成功！");
        }else{
            return ErpResult.notOk();
        }
    }
}
