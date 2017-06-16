package com.baizhi.service.impl;

import com.baizhi.VO.Favorite;
import com.baizhi.VO.My;
import com.baizhi.dao.UserMapper;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

/**
 * Created by SY on 2017/6/12.
 */

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public My<User> queryAll(Integer page, Integer rows) {
        Page<User> pages = PageHelper.startPage(page, rows);
        List<User> users = userMapper.selectAll();
        My<User> user = new My<User>();
        user.setRows(users);
        user.setTotal((int) pages.getTotal());
        return user;
    }

    public void add(User user) {
        user.setId(UUID.randomUUID().toString());
        userMapper.insert(user);
    }

    public void update(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    public void delete(String id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User queryOne(String id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Favorite> queryByUserId(String userid) {
        List<Favorite> favorites = userMapper.selectAllFavo(userid);
        return favorites;
    }
}
