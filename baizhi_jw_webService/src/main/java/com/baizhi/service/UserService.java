package com.baizhi.service;

import com.baizhi.entity.Lawer;
import com.baizhi.entity.Redpackage;
import com.baizhi.entity.User;

import java.util.List;
import java.util.Map;

/**
 * Created by SY on 2017/6/12.
 */
public interface UserService {


    //添加
    public User addUser(String phone);

    //修改
    public void update(User user);

    //查一个
    public User queryById(String id);

    //查一个
    public User queryOne(String phone);

    //查看该用户的收藏律师
   public List<Lawer> queryByUserId(String userid);

    //添加收藏
    public void addFavo(String userid,String lawerid);

    //发送验证码
    public String getCode(String phone);


    //添加心意
    public void addRed(Redpackage redpackage);
}
