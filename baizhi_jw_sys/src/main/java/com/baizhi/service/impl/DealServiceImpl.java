package com.baizhi.service.impl;

import com.baizhi.VO.My;
import com.baizhi.VO.MyDeal;
import com.baizhi.dao.DealMapper;
import com.baizhi.entity.Deal;
import com.baizhi.service.DealService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by SY on 2017/6/13.
 */
@Service("dealService")
@Transactional
public class DealServiceImpl implements DealService{
    @Autowired
    private DealMapper dealMapper;

    public My<MyDeal> queryAll(Integer page, Integer rows) {

        Page<MyDeal> pages = PageHelper.startPage(page, rows);
        List<MyDeal> myDeals = dealMapper.selectAll();


        My<MyDeal> myDealMy = new My<MyDeal>();
        myDealMy.setRows(myDeals);
        myDealMy.setTotal((int) pages.getTotal());

        return myDealMy;
    }

    public void add(Deal deal) {
        deal.setId(UUID.randomUUID().toString());
        deal.setCreatetime(new Date());
        dealMapper.insert(deal);
    }
}
