package com.baizhi.dao;

import com.baizhi.VO.RedPackage;
import com.baizhi.entity.Redpackage;

import java.util.List;

public interface RedpackageMapper {
    int deleteByPrimaryKey(String id);

    int insert(Redpackage record);

    Redpackage selectByPrimaryKey(String id);

    int updateByPrimaryKey(Redpackage record);

    //查看律师的所有红包
    List<RedPackage> selectAllByLawerid(String lawerid);
}