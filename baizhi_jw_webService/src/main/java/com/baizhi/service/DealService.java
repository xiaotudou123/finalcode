package com.baizhi.service;

import com.baizhi.entity.Deal;

/**
 * Created by SY on 2017/6/13.
 */
public interface DealService {

    //根据id查一个案例
    public Deal selectById(String id);
}
