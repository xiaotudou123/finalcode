package com.baizhi.dao;

import com.baizhi.entity.Lawertype;

import java.util.List;

public interface LawertypeMapper {
    //删除一个类别
    int deleteByPrimaryKey(String id);

    //添加一个类别
    int insert(Lawertype record);

    Lawertype selectByPrimaryKey(String id);

    //更新类别的名称
    int updateByPrimaryKey(Lawertype record);

    //查看所有类别
    List<Lawertype> selectAll();

    //查看某个律师的类别
    List<Lawertype> selectByLawerId(String lawerid);

}