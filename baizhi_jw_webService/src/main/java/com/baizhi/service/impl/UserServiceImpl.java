package com.baizhi.service.impl;

import com.baizhi.dao.UserMapper;
import com.baizhi.entity.Lawer;
import com.baizhi.entity.Redpackage;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.util.SaltUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.UUID;

/**
 * Created by SY on 2017/6/12.
 */

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private Jedis jedis;


    public User addUser(String phone) {
        User u = userMapper.selectByPhone(phone);
        if(u==null){
            User user = null;
            user = new User();
            user.setId(UUID.randomUUID().toString());
            user.setName(SaltUtils.getSalt());
            user.setMoney(0.0);
            user.setPhone(phone);
            userMapper.insert(user);
            return user;
        }else{
            return u;
        }

    }

    public void update(User user) {
        userMapper.updateByPrimaryKey(user);
    }


    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User queryOne(String phone) {
        User user = userMapper.selectByPhone(phone);
        return user;
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User queryById(String id) {
        User user = userMapper.selectById(id);
        return user;
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Lawer> queryByUserId(String userid) {
        List<Lawer> lawers = userMapper.selectAllFavo(userid);
        return lawers;
    }

    public void addFavo(String userid, String lawerid) {
        userMapper.addFavo(userid, lawerid);
    }


    public  String getCode(String phone) {
        try {
            String url = "http://gw.api.taobao.com/router/rest";
            String appkey = "23755498";
            String secret = "59fc6954002eec4e9224e1f327e1dd91";
            TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
            AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
            req.setExtend("123456");
            req.setSmsType("normal");
            req.setSmsFreeSignName("可爱的小土豆");
            String code=SaltUtils.getSalt();
            req.setSmsParamString("{\"code\":\""+code+"\"}");
            req.setRecNum(phone);
            req.setSmsTemplateCode("SMS_62295243");
            AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
            return code;
        } catch (ApiException e) {
            return null;
        }

    }

    public void addRed(Redpackage redpackage) {
        redpackage.setId(UUID.randomUUID().toString());
        userMapper.addRed(redpackage);
    }


}
