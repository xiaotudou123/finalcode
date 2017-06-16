package com.baizhi.service;

import com.baizhi.VO.Favorite;
import com.baizhi.VO.My;
import com.baizhi.entity.User;

import java.util.List;

/**
 * Created by SY on 2017/6/12.
 */
public interface UserService {

    //查所有用户
    public My<User> queryAll(Integer page, Integer rows);

    //添加
    public void add(User user);

    //修改
    public void update(User user);

    //删除
    public void delete(String id);

    //查一个
    public User queryOne(String id);

    //查看该用户的收藏律师
    public List<Favorite> queryByUserId(String userid);
}
