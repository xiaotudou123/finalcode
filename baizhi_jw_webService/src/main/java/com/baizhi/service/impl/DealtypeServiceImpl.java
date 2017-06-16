
package com.baizhi.service.impl;


import com.baizhi.dao.DealtypeMapper;
import com.baizhi.entity.Deal;
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
    public List<Dealtype> queryAll(){
        List<Dealtype> dealtypes = dealtypeMapper.selectAll();
        return dealtypes;
    }



    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Dealtype queryByOneId(String id) {
        Dealtype dealtype = dealtypeMapper.selectByOneId(id);
        return dealtype;
    }

    //查看该类别下的所有二级类别
    public Dealtype queryByTwoId(String id){
        Dealtype dealtype = dealtypeMapper.selectByTwoId(id);
        return dealtype;
    }

}
