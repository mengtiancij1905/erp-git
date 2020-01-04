package com.itqf.erp.realm;

import com.itqf.erp.pojo.Emp;
import com.itqf.erp.service.IEmpService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 飞鸟
 * @date 2019/7/11 - 16:05
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private IEmpService empService;

    //认证过程
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();

        Emp emp = empService.checkUserName(username);
        if(emp==null){
            throw new UnknownAccountException("用户名不存在!");
        }else{
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(emp, emp.getPwd(), ByteSource.Util.bytes(emp.getUsername()),"myReal");
            return info;
        }
    }


    //授权过程
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }


}
