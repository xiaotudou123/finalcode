package com.baizhi.controller;

import com.baizhi.VO.RedPackage;
import com.baizhi.service.RedpackageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by SY on 2017/6/14.
 */
@Controller
@RequestMapping("/red")
public class RedpackageController {
    @Resource
    private RedpackageService redpackageService;

    @RequestMapping("/showAllByLid")
    @ResponseBody
    public List<RedPackage> showAllByLid(String id){
        List<RedPackage> redPackages = redpackageService.queryAllByLid(id);
        return redPackages;
    }

}
