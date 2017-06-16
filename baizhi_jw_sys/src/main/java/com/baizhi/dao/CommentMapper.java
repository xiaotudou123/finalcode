package com.baizhi.dao;

import com.baizhi.VO.LawerComment;
import com.baizhi.entity.Comment;

import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(String id);

    int insert(Comment record);

    Comment selectByPrimaryKey(String id);

    int updateByPrimaryKey(Comment record);

    //根据订单id查该订单的评价内容
    Comment selectByOrderid(String orderid);

    //根据律师id查看该律师下的评价
    List<LawerComment> selectByLawerId(String lawerid);
}