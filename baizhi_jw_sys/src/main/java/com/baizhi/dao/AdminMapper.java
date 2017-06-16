package com.baizhi.dao;

import com.baizhi.entity.Admin;

public interface AdminMapper {
    int deleteByPrimaryKey(String id);

    int insert(Admin record);

    Admin selectByPrimaryKey(String id);


    //登录
    Admin selectByName(String adminname);

    int updateByPrimaryKey(Admin record);
}