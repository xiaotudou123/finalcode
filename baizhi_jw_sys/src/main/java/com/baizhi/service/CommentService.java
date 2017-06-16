package com.baizhi.service;

import com.baizhi.VO.LawerComment;
import com.baizhi.VO.My;
import com.baizhi.entity.Comment;

import java.util.List;


/**
 * Created by SY on 2017/6/14.
 */
public interface CommentService {

    //根据律师查看评价内容
    public List<LawerComment> queryByLawerid(String lawerid);
}
