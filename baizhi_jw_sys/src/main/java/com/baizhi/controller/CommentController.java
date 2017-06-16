package com.baizhi.controller;

import com.baizhi.VO.LawerComment;
import com.baizhi.entity.Comment;
import com.baizhi.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by SY on 2017/6/14.
 */
@Controller
@RequestMapping("/comment")
public class CommentController {
    @Resource
    private CommentService commentService;

    //根据律师id查评价
    @RequestMapping("/showAllById")
    @ResponseBody
    public List<LawerComment> showAllById(String id){
        List<LawerComment> lawerComments = commentService.queryByLawerid(id);
        return lawerComments;
    }

}
