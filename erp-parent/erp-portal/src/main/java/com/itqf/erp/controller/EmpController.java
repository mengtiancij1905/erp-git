package com.itqf.erp.controller;

import com.itqf.erp.pojo.EasyUIDataGrid;
import com.itqf.erp.pojo.Emp;
import com.itqf.erp.pojo.ErpResult;
import com.itqf.erp.service.IEmpService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 飞鸟
 * @date 2019/7/10 - 14:11
 */
@RestController
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private IEmpService empService;
    //我的测试

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，false:不能为空值
    }

    @RequestMapping("/search")
    public EasyUIDataGrid<Emp> search(Emp emp , Date birthday2, @RequestParam(value="page", defaultValue = "1") int page, @RequestParam(value="rows", defaultValue = "10") int rows){
        //jackson进行对象转换-》ObjectMapper-》{"total":"",rows:[{},{},{}]}
        System.out.println(emp);
        System.out.println(birthday2);
        return empService.search(emp, birthday2, page, rows);
    }

    @RequestMapping("/add")
    public ErpResult add(Emp emp){
        return empService.add(emp);
    }

    @RequestMapping("/get")
    public Emp get(Integer uuid){
        return empService.get(uuid);
    }

    @RequestMapping("/checklogin")
    public ErpResult checkLogin(String username, String password, HttpSession session){
        /*
        Emp emp = empService.checkUserName(username);
        if(emp ==null){
            return ErpResult.notOk("用户名不存在！");
        }else{
            if(emp.getPwd().equalsIgnoreCase(password)){
                return ErpResult.ok();
            }else{
                return ErpResult.notOk("密码错误");
            }
        }
        */

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);

            Emp emp = (Emp) subject.getPrincipal();
            //将用户信息记录在session中
            session.setAttribute("user", emp);

            return ErpResult.ok("登录成功！");
        }catch(UnknownAccountException e){
            e.printStackTrace();
            //用户名不存在
            return ErpResult.notOk("用户名不存在!");
        }catch(IncorrectCredentialsException e){
            e.printStackTrace();
            return ErpResult.notOk("密码错误");
        }catch(Exception e){
            e.printStackTrace();
            return ErpResult.notOk("未知错误!");
        }
    }

    @RequestMapping("/getname")
    public Emp getname(HttpSession session){
        Emp emp = (Emp) session.getAttribute("user");
        return emp;
    }
}
