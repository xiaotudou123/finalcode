package com.baizhi.dao;


import com.baizhi.entity.Lawer;
import com.baizhi.entity.Redpackage;
import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    int insert(User record);

    int updateByPrimaryKey(User record);

    //查一个
    User selectByPhone(String phone);
    User selectById(String id);

    //查看所有用户
    List<User> selectAll();

    //根据用户手机号登录

    //查看该用户收藏的律师
    List<Lawer> selectAllFavo(String userid);

    //添加收藏
    void addFavo(@Param("userid") String userid, @Param("lawerid") String lawerid);

    //添加心意
    void addRed(Redpackage redpackage);
}