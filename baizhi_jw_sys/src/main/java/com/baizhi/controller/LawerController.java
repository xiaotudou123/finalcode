package com.baizhi.controller;

import com.baizhi.VO.My;
import com.baizhi.entity.Lawer;
import com.baizhi.service.LawerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * Created by SY on 2017/6/12.
 */
@Controller
@RequestMapping("/lawer")
public class LawerController {

    @Resource
    private LawerService lawerService;

    //查所有律师
    @RequestMapping("/showAll")
    @ResponseBody
    public My<Lawer> showAll(Integer page, Integer rows){
        My<Lawer> lawerMy = lawerService.queryAll(page, rows);
        return lawerMy;
    }

    //查一个律师

    @RequestMapping("/showOne")
    @ResponseBody
    public Lawer showOne(String id){
        Lawer lawer = lawerService.queryOne(id);
        return lawer;
    }

    //添加一个律师
    @RequestMapping("/add")
    public void add(Lawer lawer,String[] lawerTypes){
        lawer.setId(UUID.randomUUID().toString());
        lawerService.add(lawer,lawerTypes);
    }
    //删除一个律师
    @RequestMapping("/delete")
    public void delete(String id){
        lawerService.delete(id);
    }
    //更新一个律师
    @RequestMapping("/update")
    public void update(Lawer lawer){
        lawerService.update(lawer);
    }




}
