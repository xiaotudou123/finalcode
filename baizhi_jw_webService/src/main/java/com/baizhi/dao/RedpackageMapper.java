package com.baizhi.dao;

import com.baizhi.entity.Redpackage;

import java.util.List;

public interface RedpackageMapper {

    int insert(Redpackage record);

    Redpackage selectByPrimaryKey(String id);

    //查看律师的所有红包
    List<Redpackage> selectAllByLawerid(String lawerid);
}