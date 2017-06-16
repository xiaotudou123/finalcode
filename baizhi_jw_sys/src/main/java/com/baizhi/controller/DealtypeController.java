package com.baizhi.controller;

import com.baizhi.VO.My;
import com.baizhi.entity.Deal;
import com.baizhi.entity.Dealtype;
import com.baizhi.service.DealtypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by SY on 2017/6/13.
 */
@Controller
@RequestMapping("/dealtype")
public class DealtypeController {
    @Resource
    private DealtypeService dealtypeService;

    //查看所有一级类别
    @RequestMapping("/showAll")
    @ResponseBody
    public My<Dealtype> showAll(Integer page,Integer rows){
        My<Dealtype> dealtypeMy = dealtypeService.queryAll(page, rows);
        return dealtypeMy;
    }

    @RequestMapping("/showAlll")
    @ResponseBody
    public List<Dealtype> showAll1(){
        List<Dealtype> dealtypes = dealtypeService.queryAll();
        return dealtypes;
    }

    @RequestMapping("/showAll2")
    @ResponseBody
    public List<Dealtype> showAll2(String id){
        List<Dealtype> dealtypes = dealtypeService.queryAll(id);
        return dealtypes;
    }


    //添加一个案例类别
    @RequestMapping("/add")
    public void add(Dealtype dealtype){
        dealtypeService.add(dealtype);
    }

    //查看所有二级类别
    @RequestMapping("/showAllTwo")
    @ResponseBody
    public List<Dealtype> showAllTwo(){
        List<Dealtype> dealtypes = dealtypeService.queryAllTwo();
        return dealtypes;
    }


    //根据id查一个类别的详细
    @RequestMapping("/showOneById")
    @ResponseBody
    public Dealtype showOneById(String id){
        Dealtype dealtype = dealtypeService.queryOne(id);
        return dealtype;
    }

    //根据id修改一个
    @RequestMapping("/update")
    public void update(Dealtype dealtype){
        dealtypeService.update(dealtype);
    }
}
