package com.baizhi.controller;

import com.baizhi.VO.Favorite;
import com.baizhi.VO.My;
import com.baizhi.dao.UserMapper;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by SY on 2017/6/12.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    //查所有用户
    @RequestMapping("/showAll")
    @ResponseBody
    public My<User> showAll(Integer page, Integer rows){
        My<User> userMy = userService.queryAll(page, rows);
        return userMy;
    }


    //添加用户
    @RequestMapping("/add")
    public void add(User user){
        userService.add(user);
    }

    //删除用户
    @RequestMapping("/delete")
    public void delete(String id){
        userService.delete(id);
    }

    //查一个用户
    @RequestMapping("/showOne")
    @ResponseBody
    public User showOne(String id){
        User user = userService.queryOne(id);
        return user;
    }

    //更新一个用户
    @RequestMapping("/update")
    public void update(User user){
        userService.update(user);
    }

    //查该用户的收藏律师
    @RequestMapping("/showFavo")
    @ResponseBody
    public List<Favorite> showFavo(String id){
        List<Favorite> favorites = userService.queryByUserId(id);
        return favorites;
    }
}
