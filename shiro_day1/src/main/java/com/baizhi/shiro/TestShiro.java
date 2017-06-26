package com.baizhi.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * Created by SY on 2017/6/19.
 */
public class TestShiro {

    public static void main(String[] args) {
        //创建安全管理器工厂
        IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory("classpath:shiro.ini");

        //安全管理器
        SecurityManager instance = iniSecurityManagerFactory.getInstance();

        SecurityUtils.setSecurityManager(instance);

        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(new UsernamePasswordToken("zhangsan","123456"));
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        System.out.println(subject.isAuthenticated());


    }

}
