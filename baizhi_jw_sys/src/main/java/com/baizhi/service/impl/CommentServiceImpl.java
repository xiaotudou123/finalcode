package com.baizhi.service.impl;

import com.baizhi.VO.LawerComment;
import com.baizhi.VO.My;
import com.baizhi.dao.CommentMapper;
import com.baizhi.entity.Comment;
import com.baizhi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by SY on 2017/6/14.
 */
@Service("commentService")
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<LawerComment> queryByLawerid(String lawerid) {
        List<LawerComment> comments = commentMapper.selectByLawerId(lawerid);
        return comments;
    }
}
