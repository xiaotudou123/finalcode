package com.baizhi.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;

/**
 * Created by SY on 2017/6/19.
 */
public class MyRealm extends AuthenticatingRealm{
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {

           if("zhangsan".equals(authenticationToken.getPrincipal())){

               return new SimpleAccount("zhangsan","123456",this.getName());
           }




        return null;
    }
}
