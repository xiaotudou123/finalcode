package com.baizhi.service.impl;

import com.baizhi.VO.RedPackage;
import com.baizhi.dao.RedpackageMapper;
import com.baizhi.entity.Redpackage;
import com.baizhi.service.RedpackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by SY on 2017/6/14.
 */
@Service("redService")
@Transactional
public class RedpackageServiceImpl implements RedpackageService {
    @Autowired
    private RedpackageMapper redpackageMapper;


    public List<RedPackage> queryAllByLid(String lawerid) {
        List<RedPackage> redPackages = redpackageMapper.selectAllByLawerid(lawerid);
        return redPackages;
    }
}
