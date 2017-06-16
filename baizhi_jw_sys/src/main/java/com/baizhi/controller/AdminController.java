package com.baizhi.controller;

import com.baizhi.VO.Choose;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by SY on 2017/6/13.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private AdminService adminService;

    //登录
    @RequestMapping("/login")
    @ResponseBody
    public Choose login(Admin admin){
        Choose choose = new Choose();
        System.out.println(admin);
        Admin admin1 = adminService.queryByName(admin);
        System.out.println(admin1);
        if(admin1==null){
            System.out.println("11111111");
            return choose;
        }else{
            choose.setTemp(true);
            return choose;
        }
    }
}
