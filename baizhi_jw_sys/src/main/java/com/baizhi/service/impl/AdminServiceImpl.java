package com.baizhi.service.impl;

import com.baizhi.dao.AdminMapper;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by SY on 2017/6/13.
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminMapper adminMapper;

    public Admin queryByName(Admin admin) {
        Admin adminDb = adminMapper.selectByName(admin.getAdminname());
        if(admin.getPassword().equals(adminDb.getPassword())){
            return adminDb;
        }else{
            return null;
        }

    }
}
