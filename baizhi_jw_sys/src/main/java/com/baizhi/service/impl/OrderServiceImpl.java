package com.baizhi.service.impl;

import com.baizhi.VO.My;
import com.baizhi.VO.MyOrder;
import com.baizhi.dao.CommentMapper;
import com.baizhi.dao.OrderMapper;
import com.baizhi.entity.Comment;
import com.baizhi.service.OrderService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by SY on 2017/6/13.
 */
@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private CommentMapper commentMapper;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public My<MyOrder> queryAll(Integer page,Integer rows) {
        Page<MyOrder> pages = PageHelper.startPage(page, rows);
        List<MyOrder> myOrders = orderMapper.selectAll();
        My<MyOrder> myOrderMy = new My<MyOrder>();
        myOrderMy.setRows(myOrders);
        myOrderMy.setTotal((int) pages.getTotal());
        return myOrderMy;
    }

    public void delete(String id) {
        orderMapper.deleteByPrimaryKey(id);
    }

    public Comment queryByOrderid(String id) {
        Comment comment = commentMapper.selectByOrderid(id);
        return comment;
    }
}
