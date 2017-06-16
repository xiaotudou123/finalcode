package com.baizhi.dao;

import com.baizhi.entity.Lawer;
import com.baizhi.entity.Lawertype;

import java.util.List;

public interface LawertypeMapper {


    Lawertype selectByPrimaryKey(String id);

    //查看所有类别
    List<Lawertype> selectAll();

    //查看某个律师的类别
    List<Lawertype> selectByLawerId(String lawerid);

    //查看该类别下的所有律师
    Lawertype selectByLawertypeid(String lawertypeid);


}