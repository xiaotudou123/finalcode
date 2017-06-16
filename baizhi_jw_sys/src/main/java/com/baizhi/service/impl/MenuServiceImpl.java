package com.baizhi.service.impl;

import com.baizhi.dao.MenuMapper;
import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by SY on 2017/6/11.
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    public List<Menu> queryAll() {

        List<Menu> menus = menuMapper.selectAll();
        return menus;
    }
}
