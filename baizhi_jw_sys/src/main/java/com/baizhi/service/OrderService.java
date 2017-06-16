package com.baizhi.service;

import com.baizhi.VO.My;
import com.baizhi.VO.MyOrder;
import com.baizhi.entity.Comment;

import java.util.List;

/**
 * Created by SY on 2017/6/13.
 */
public interface OrderService {
    //查看所有订单
    public My<MyOrder> queryAll(Integer page, Integer rows);
    //删除一个订单
    public void delete(String id);
    //查看该订单的评价
    public Comment queryByOrderid(String id);
}
