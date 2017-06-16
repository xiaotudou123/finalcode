package com.baizhi.service.impl;

import com.baizhi.VO.My;
import com.baizhi.dao.DealtypeMapper;
import com.baizhi.entity.Dealtype;
import com.baizhi.service.DealtypeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Created by SY on 2017/6/13.
 */
@Service("dealtypeService")
@Transactional
public class DealtypeServiceImpl implements DealtypeService {
    @Autowired
    private DealtypeMapper dealtypeMapper;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public My<Dealtype> queryAll(Integer page,Integer rows) {
        Page<Dealtype> pages = PageHelper.startPage(page, rows);
        List<Dealtype> dealtypes = dealtypeMapper.selectAll();
        My<Dealtype> dealtypeMy = new My<Dealtype>();
        dealtypeMy.setRows(dealtypes);
        dealtypeMy.setTotal((int) pages.getTotal());
        return dealtypeMy;
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Dealtype> queryAll(){
        List<Dealtype> dealtypes = dealtypeMapper.selectAll();
        return dealtypes;
    }


    public void add(Dealtype dealtype) {
        dealtype.setId(UUID.randomUUID().toString());
        if(dealtype.getParentid().length()>0) {
            dealtype.setParentid(dealtype.getParentid());
            dealtype.setFlag("2");
        }else{
            dealtype.setParentid(null);
            dealtype.setFlag("1");
        }
        dealtypeMapper.insert(dealtype);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Dealtype> queryAll(String id) {
        List<Dealtype> dealtypes = dealtypeMapper.selectById(id);
        return dealtypes;
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Dealtype> queryAllTwo() {
        List<Dealtype> dealtypes = dealtypeMapper.selectAllTwo();
        return dealtypes;
    }
}
