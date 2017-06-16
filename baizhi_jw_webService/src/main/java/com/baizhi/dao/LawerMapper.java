package com.baizhi.dao;

import com.baizhi.entity.Lawer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LawerMapper {

    //查看一个律师
    Lawer selectByPrimaryKey(String id);

    //查所有律师
    List<Lawer> selectAll();

}