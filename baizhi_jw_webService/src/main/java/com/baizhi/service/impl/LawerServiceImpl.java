package com.baizhi.service.impl;

import com.baizhi.dao.LawerMapper;
import com.baizhi.entity.Lawer;
import com.baizhi.service.LawerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by SY on 2017/6/12.
 */
@Service("lawerService")
@Transactional
public class LawerServiceImpl implements LawerService {

    @Autowired
    private LawerMapper lawerMapper;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Lawer> queryAll() {
        List<Lawer> lawers = lawerMapper.selectAll();
        return lawers;
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Lawer queryOne(String id) {
        Lawer lawer = lawerMapper.selectByPrimaryKey(id);
        return lawer;
    }


}
