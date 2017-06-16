package com.baizhi.service;

import com.baizhi.VO.My;
import com.baizhi.annotation.RedisAnnotation;
import com.baizhi.entity.Lawer;

import java.util.List;

/**
 * Created by SY on 2017/6/12.
 */
public interface LawerService {

    //查所有律师
    @RedisAnnotation
    public My<Lawer> queryAll(Integer page, Integer rows);

    //查一个律师
    public Lawer queryOne(String id);

    //更新一个
    public int update(Lawer lawer);
    //添加一个
    public void add(Lawer lawer,String[] lawerTypes);
    //删除一个
    public int delete(String id );
}
