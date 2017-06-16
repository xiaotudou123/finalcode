package com.baizhi.service.impl;


import com.baizhi.dao.LawertypeMapper;
import com.baizhi.entity.Lawertype;
import com.baizhi.service.LawertypeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Created by SY on 2017/6/12.
 */
@Service("lawertypeService")
@Transactional
public class LawertypeServiceImpl implements LawertypeService{
    @Autowired
    private LawertypeMapper lawertypeMapper;


    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Lawertype queryOne(String id) {
        Lawertype lawertype = lawertypeMapper.selectByPrimaryKey(id);
        return lawertype;
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Lawertype> queryLawertypes() {
        List<Lawertype> lawertypes = lawertypeMapper.selectAll();
        return lawertypes;
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Lawertype> queryAll(String lawerid) {
        List<Lawertype> lawertypes = lawertypeMapper.selectByLawerId(lawerid);
        return lawertypes;
    }

    //查看该类别下的所有律师
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Lawertype selectByLawertypeid(String lawertypeid){
        Lawertype lawertype = lawertypeMapper.selectByLawertypeid(lawertypeid);
        return lawertype;
    }

}
