package com.baizhi.service;

import com.baizhi.entity.Lawer;

import java.util.List;

/**
 * Created by SY on 2017/6/12.
 */
public interface LawerService {

    //查所有律师
    public List<Lawer> queryAll();


    //查一个律师
    public Lawer queryOne(String id);


}
