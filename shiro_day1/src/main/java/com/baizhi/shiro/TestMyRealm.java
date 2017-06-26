package com.baizhi.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * Created by SY on 2017/6/19.
 */
public class TestMyRealm {

    public static void main(String[] args) {
        IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");

        SecurityManager instance = iniSecurityManagerFactory.getInstance();

        SecurityUtils.setSecurityManager(instance);

        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(new UsernamePasswordToken("zhangsan","123456ww"));
        } catch (UnknownAccountException e) {
            System.out.println("用户名错误~~~");
        }catch (IncorrectCredentialsException e){
            System.out.println("密码错误~~~~");
        }
        System.out.println(subject.isAuthenticated());


    }
}
