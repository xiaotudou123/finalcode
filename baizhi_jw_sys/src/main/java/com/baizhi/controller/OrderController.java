package com.baizhi.controller;

import com.baizhi.VO.My;
import com.baizhi.VO.MyOrder;
import com.baizhi.entity.Comment;
import com.baizhi.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by SY on 2017/6/13.
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderService orderService;

    //查看所有订单
    @RequestMapping("/showAll")
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @ResponseBody
    private My<MyOrder> showAll(Integer page,Integer rows){
        My<MyOrder> myOrderMy = orderService.queryAll(page, rows);
        return myOrderMy;
    }

    //删除一个订单
    public void delete(String id){

    }

    //查看订单的评价
    @RequestMapping("/showComment")
    @ResponseBody
    public Comment showComment(String id){
        Comment comment = orderService.queryByOrderid(id);
        return comment;
    }


}
