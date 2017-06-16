package com.baizhi.service;

import com.baizhi.entity.Admin;

/**
 * Created by SY on 2017/6/13.
 */
public interface AdminService {

    //登录
    public Admin queryByName(Admin admin);
}
