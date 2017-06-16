package com.baizhi.service;

import com.baizhi.VO.My;
import com.baizhi.VO.MyDeal;
import com.baizhi.entity.Deal;

/**
 * Created by SY on 2017/6/13.
 */
public interface DealService {

    //查看所有案例
    public My<MyDeal> queryAll(Integer page, Integer rows);
    //添加一个案例
    public void add(Deal deal);
}
