package com.baizhi.service;

import com.baizhi.VO.My;
import com.baizhi.entity.Deal;
import com.baizhi.entity.Dealtype;

import java.util.List;

/**
 * Created by SY on 2017/6/13.
 */
public interface DealtypeService {

    //查看所有一级类别
    public My<Dealtype> queryAll(Integer page,Integer rows);
    public List<Dealtype> queryAll();

    //添加案例类别
    public void add(Dealtype dealtype);

    //查看该类别下的所有二级类别
    public List<Dealtype> queryAll(String id);

    //查看所有二级类别
    public List<Dealtype> queryAllTwo();

    //根据id查一个类别的详细
    public Dealtype queryOne(String id);

    //修改一个类别的名称
    public void update(Dealtype dealtype);

}
