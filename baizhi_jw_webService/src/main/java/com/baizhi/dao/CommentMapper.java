package com.baizhi.dao;

import com.baizhi.entity.Comment;

import java.util.List;

public interface CommentMapper {
    int insert(Comment record);

    Comment selectByPrimaryKey(String id);

    //根据订单id查该订单的评价内容
    Comment selectByOrderid(String orderid);

    //根据律师id查看该律师下的评价
    List<Comment> selectByLawerId(String lawerid);
}