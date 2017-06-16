package com.baizhi.service.impl;

import com.baizhi.dao.DealMapper;
import com.baizhi.entity.Deal;
import com.baizhi.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by SY on 2017/6/13.
 */
@Service("dealService")
@Transactional
public class DealServiceImpl implements DealService{
    @Autowired
    private DealMapper dealMapper;


    public Deal selectById(String id) {
        Deal deal = dealMapper.selectByPrimaryKey(id);
        return deal;
    }
}
