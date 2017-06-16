package com.baizhi.dao;

import com.baizhi.entity.Dealtype;

import java.util.List;

public interface DealtypeMapper {



    //查所有一级标签
    List<Dealtype> selectAll();

    //根据一级id查详细
    Dealtype selectByOneId(String id);

    //查看该类别的所有二级案例类别
    Dealtype selectByTwoId(String id);


}