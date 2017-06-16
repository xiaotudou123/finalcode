package com.baizhi.dao;

import com.baizhi.entity.Dealtype;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DealtypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(Dealtype record);

    Dealtype selectByPrimaryKey(String id);

    int updateByPrimaryKey(Dealtype record);

    //查所有一级标签
    List<Dealtype> selectAll();

    //查看该类别的所有二级案例类别
    List<Dealtype> selectById(String id);

    //查看所有二级分类
    List<Dealtype> selectAllTwo();

}