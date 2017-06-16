package com.baizhi.controller;

import com.baizhi.VO.My;
import com.baizhi.VO.MyDeal;
import com.baizhi.entity.Deal;
import com.baizhi.service.DealService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by SY on 2017/6/13.
 */
@Controller
@RequestMapping("/deal")
public class DealController {
    @Resource
    private DealService dealService;

    @RequestMapping("/showAll")
    @ResponseBody
    public My<MyDeal> showAll(Integer page,Integer rows){
        My<MyDeal> myDealMy = dealService.queryAll(page, rows);
        return myDealMy;
    }

    @RequestMapping("/add")
    public void add(Deal deal,String dealtypeid){
        System.out.println("1111111111111");
        System.out.println(deal);
        System.out.println(dealtypeid);
        deal.setDealtypeid(dealtypeid);
        dealService.add(deal);
    }
}
