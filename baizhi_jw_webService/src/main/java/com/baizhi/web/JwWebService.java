package com.baizhi.web;

import com.baizhi.entity.Lawer;
import com.baizhi.entity.Redpackage;
import com.baizhi.entity.User;

import javax.jws.WebService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SY on 2017/6/15.
 */
@WebService
public interface JwWebService {
    /**
     * 律师
     * @return
     */
    //查看所有律师
    public HashMap<String,Object> showAllLawer();
    //根据律师id查看律师
    public HashMap<String,Object> showOneLawer(String id);


    /**
     * 用户
     * @param id
     * @return
     */
    //查一个用户
    public HashMap<String,Object> showOneUser(String id);

    //展示用户收藏的律师
    public HashMap<String,Object> showAllFavo(String id);

    //添加一个用户
    public HashMap<String,Object> addUser(String phone,String code);

    //添加收藏
    public HashMap<String,Object> addFavo(String userid,String lawerid);

    //取消收藏


    //发送验证码
    public HashMap<String,Object> getCode(String phone);

    //添加心意
    public HashMap<String,Object> addRed(Redpackage redpackage);




    /**
     * 展示案例类别
     */
    //展示所有一级类别
    public HashMap<String,Object> showAllDealType();

    //展示所有一级类别下的所有案例以及所有二级类别 和二级类别案例
    public HashMap<String,Object> showByOneId(String id);

    //根据二级分类id展示所有案例
    public HashMap<String,Object> showByTwoId(String id);

    //根据id展示案例
    public HashMap<String,Object> showOneDeal(String id);



    /**
     * 律师类别
     */
    //展示所有律师类别
    public HashMap<String,Object> showAllLawertypes();

    //展示某类别下的所有律师
    public HashMap<String,Object> showByLawertypeid(String lawertypeid);


    /**
     * 订单
     */
    //添加评价
}
