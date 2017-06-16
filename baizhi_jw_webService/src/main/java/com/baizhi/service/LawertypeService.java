package com.baizhi.service;

import com.baizhi.entity.Lawertype;

import java.util.List;

;

/**
 * Created by SY on 2017/6/12.
 */
public interface LawertypeService {


    //查所有
    public List<Lawertype> queryLawertypes();

    //查一个律师的类别
    public List<Lawertype> queryAll(String lawerid);


    //查一个
    public Lawertype queryOne(String id);


    //查看该类别下的所有律师
    Lawertype selectByLawertypeid(String lawertypeid);
}
