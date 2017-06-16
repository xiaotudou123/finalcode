package com.baizhi.dao;

import com.baizhi.VO.My;
import com.baizhi.VO.MyDeal;
import com.baizhi.entity.Deal;
import com.baizhi.entity.Dealtype;

import java.util.List;

public interface DealMapper {
    int deleteByPrimaryKey(String id);

    int insert(Deal record);

    Deal selectByPrimaryKey(String id);

    int updateByPrimaryKey(Deal record);

    //查看所有案例
    List<MyDeal> selectAll();
}