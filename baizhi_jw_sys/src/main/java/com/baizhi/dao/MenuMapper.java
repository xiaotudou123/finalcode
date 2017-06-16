package com.baizhi.dao;

import com.baizhi.entity.Menu;

import java.util.List;

public interface MenuMapper {
    int delete(String id);

    int save(Menu record);

    Menu queryOne(String id);

    int update(Menu record);

    //查看所有菜单
    List<Menu> selectAll();
}