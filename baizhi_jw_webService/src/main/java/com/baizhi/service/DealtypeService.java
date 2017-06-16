package com.baizhi.service;

import com.baizhi.entity.Dealtype;

import java.util.List;

/**
 * Created by SY on 2017/6/13.
 */
public interface DealtypeService {

    //查看所有一级类别
    public List<Dealtype> queryAll();

    //根据一级id展示详细
    public Dealtype queryByOneId(String id);

    //查看该类别下的所有二级类别
    public Dealtype queryByTwoId(String id);


}
