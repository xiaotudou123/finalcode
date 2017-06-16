package com.baizhi.service;

;
import com.baizhi.VO.My;
import com.baizhi.entity.Lawertype;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * Created by SY on 2017/6/12.
 */
public interface LawertypeService {

    //查所有
    public My<Lawertype> queryAll(Integer page, Integer rows);

    //查所有
    public List<Lawertype> queryTypes();

    //查一个律师的类别
    public List<Lawertype> queryAll(String lawerid);

    //添加一个分类
    public void add(Lawertype lawertype);

    //更新
    public void update(Lawertype lawertype);
    //删除
    public void delete(String id);

    //查一个
    public Lawertype queryOne(String id);
}
