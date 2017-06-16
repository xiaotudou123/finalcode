package com.baizhi.controller;


import com.baizhi.VO.My;
import com.baizhi.entity.Lawertype;
import com.baizhi.service.LawertypeService;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by SY on 2017/6/12.
 */
@Controller
@RequestMapping("/lawertype")
public class LawertypeController {
    @Resource
    private LawertypeService lawertypeService;

    //查所有律师类别

    @RequestMapping("/showAll1")
    @ResponseBody
    public List<Lawertype> showAll1(){
        //System.out.println("rows:"+rows);
        List<Lawertype> lawertypes = lawertypeService.queryTypes();
        return lawertypes;
    }


    @RequestMapping("/showAll")
    @ResponseBody
    public My<Lawertype> showAll(Integer page, Integer rows){
        //System.out.println("rows:"+rows);
        My<Lawertype> lawerType = lawertypeService.queryAll(page, rows);
        return lawerType;
    }

    //添加一个律师的类别
    @RequestMapping("/add")
    public void add(Lawertype lawertype){
        lawertypeService.add(lawertype);
    }

    //更新一个类别
    @RequestMapping("/update")
    public void update(Lawertype lawertype){
        lawertypeService.update(lawertype);
    }

    //删除
    @RequestMapping("/delete")
    public void delete(String id){
        System.out.println("delete:"+id);
        lawertypeService.delete(id);
    }

    //查一个
    @RequestMapping("/queryOne")
    @ResponseBody
    public Lawertype queryOne(String id){
        Lawertype lawertype = lawertypeService.queryOne(id);
        return lawertype;
    }

    //查看一个律师的类别
    @RequestMapping("/showLawerTypes")
    @ResponseBody
    public List<Lawertype> showLawerTypes(String id){
        List<Lawertype> lawertypes = lawertypeService.queryAll(id);
        return lawertypes;
    }
}
