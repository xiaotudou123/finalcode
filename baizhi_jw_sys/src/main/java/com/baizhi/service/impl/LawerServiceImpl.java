package com.baizhi.service.impl;

import com.baizhi.VO.My;
import com.baizhi.dao.LawerMapper;
import com.baizhi.entity.Lawer;
import com.baizhi.entity.Lawertype;
import com.baizhi.service.LawerService;
import com.baizhi.util.MD5Utils;
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
@Service("lawerService")
@Transactional
public class LawerServiceImpl implements LawerService {

    @Autowired
    private LawerMapper lawerMapper;


    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public My<Lawer> queryAll(Integer pageNum, Integer rows) {
        Page<Lawer> page = PageHelper.startPage(pageNum, rows);
        List<Lawer> lawers = lawerMapper.selectAll();
        My<Lawer> lawer = new My<Lawer>();
        lawer.setRows(lawers);
        lawer.setTotal((int) page.getTotal());
        return lawer;
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Lawer queryOne(String id) {
        System.out.println("service:"+id);
        Lawer lawer = lawerMapper.selectByPrimaryKey(id);
        return lawer;
    }

    public int update(Lawer lawer) {
        int i = lawerMapper.updateByPrimaryKey(lawer);
        return i;
    }

    public void add(Lawer lawer,String[] lawerTypes) {
        lawer.setId(UUID.randomUUID().toString());
        int i = lawerMapper.insert(lawer);
        for (String lawerTypeid : lawerTypes) {
            lawerMapper.add(lawer.getId(),lawerTypeid);
        }
    }

    public int delete(String id) {
        int i = lawerMapper.deleteByPrimaryKey(id);
        return i;

    }
}
