package com.baizhi.service.impl;


import com.baizhi.VO.My;
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
    public My<Lawertype> queryAll(Integer pageNum, Integer rows) {
        Page<Lawertype> page = PageHelper.startPage(pageNum, rows);
        List<Lawertype> lawertypes = lawertypeMapper.selectAll();
        My<Lawertype> lawerType = new My<Lawertype>();
        lawerType.setRows(lawertypes);
        lawerType.setTotal((int) page.getTotal());
        return lawerType;
    }

    public void add(Lawertype lawertype) {
        lawertype.setId(UUID.randomUUID().toString());
        lawertypeMapper.insert(lawertype);
    }

    public void update(Lawertype lawertype) {
        lawertypeMapper.updateByPrimaryKey(lawertype);
    }

    public void delete(String id) {
        lawertypeMapper.deleteByPrimaryKey(id);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Lawertype queryOne(String id) {
        Lawertype lawertype = lawertypeMapper.selectByPrimaryKey(id);
        return lawertype;
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Lawertype> queryTypes() {
        List<Lawertype> lawertypes = lawertypeMapper.selectAll();
        return lawertypes;
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Lawertype> queryAll(String lawerid) {
        List<Lawertype> lawertypes = lawertypeMapper.selectByLawerId(lawerid);
        return lawertypes;
    }

}
