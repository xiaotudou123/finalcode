package com.baizhi.service;

import com.baizhi.VO.RedPackage;

import java.util.List;

/**
 * Created by SY on 2017/6/14.
 */
public interface RedpackageService {

    //查看律师的所有红包
    public List<RedPackage> queryAllByLid(String lawerid);

}
