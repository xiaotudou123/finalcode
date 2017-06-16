package com.baizhi.dao;

import com.baizhi.VO.Favorite;
import com.baizhi.entity.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKey(User record);

    //查看所有用户
    List<User> selectAll();

    //查看该用户收藏的律师
    List<Favorite> selectAllFavo(String userid);
}