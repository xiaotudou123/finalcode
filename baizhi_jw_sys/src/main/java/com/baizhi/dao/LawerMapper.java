package com.baizhi.dao;

import com.baizhi.entity.Lawer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LawerMapper {
    //删除一个律师
    int deleteByPrimaryKey(String id);

    int insert(Lawer record);

    //查看一个律师
    Lawer selectByPrimaryKey(String id);

    int updateByPrimaryKey(Lawer record);

    //查所有律师
    List<Lawer> selectAll();

    //添加一个律师及律师的类型
    void add(@Param("lawerid") String lawerid, @Param("lawertypeid") String lawertypeid);
}