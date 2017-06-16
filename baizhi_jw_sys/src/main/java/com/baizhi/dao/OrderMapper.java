package com.baizhi.dao;

import com.baizhi.VO.MyOrder;
import com.baizhi.entity.Order;

import java.util.List;

public interface OrderMapper {
    //删除一个订单
    int deleteByPrimaryKey(String id);

    int insert(Order record);

    Order selectByPrimaryKey(String id);

    int updateByPrimaryKey(Order record);

    //查所有订单
    public List<MyOrder> selectAll();
}