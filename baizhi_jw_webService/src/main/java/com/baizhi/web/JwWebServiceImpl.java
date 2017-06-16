package com.baizhi.web;

import com.baizhi.entity.*;
import com.baizhi.service.*;
import com.baizhi.util.MD5Utils;
import com.baizhi.web.JwWebService;
import org.apache.ibatis.annotations.Param;
import org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.ws.rs.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SY on 2017/6/15.
 */
@WebService
@Path("/jw")
public class JwWebServiceImpl implements JwWebService {
    @Resource
    private LawerService lawerService;
    @Resource
    private UserService userService;
    @Resource
    private Jedis jedis;
    @Resource
    private DealtypeService dealtypeService;
    @Resource
    private LawertypeService lawertypeService;
    @Resource
    private DealService dealService;

    /**
     * 律师
     * @return
     */
    @Path("/showAllLawer")
    @GET
    @Produces("application/json;charset=utf-8")
    public HashMap<String,Object> showAllLawer() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        try{
            List<Lawer> lawers = lawerService.queryAll();
            map.put("status",1);
            map.put("success",lawers);
        }catch (Exception e){
            map.put("status",0);
        }
        return map;
    }

    @GET
    @Path("/showOneLawer/{id}")
    @Produces("application/json;charset=utf-8")
    @Consumes("application/json;charset=utf-8")
    public HashMap<String,Object> showOneLawer(@PathParam("id") String id) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        try{
            Lawer lawer = lawerService.queryOne(id);
            map.put("status",1);
            map.put("success",lawer);
        }catch (Exception e){
            map.put("status",0);
        }
        return map;
    }


    /**
     * 用户
     * @param id
     * @return
     */
    @Path("/showOneUser/{id}")
    @GET
    @Produces("application/json;charset=utf-8")
    @Consumes("application/json;charset=utf-8")
    public HashMap<String,Object> showOneUser(@PathParam("id") String id) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        try{
            User user = userService.queryById(id);
            if(user!=null){
                map.put("status",1);
                map.put("success",user);
            }else{

            }
        }catch (Exception e){
            map.put("status",0);
        }
        return map;
    }

    @Path("showAllFavo")
    @GET
    @Produces("application/json;charset=utf-8 ")
    @Consumes("application/json;charset=utf-8")
    public HashMap<String,Object> showAllFavo(String id) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        try{
            List<Lawer> lawers = userService.queryByUserId(id);
            map.put("status",1);
            map.put("success",lawers);
        }catch (Exception e){
            map.put("status",0);
        }
        return map;
    }

    @POST
    @Path("/addFavo")
    @Consumes("application/json;charset=utf-8")
    public HashMap<String,Object> addFavo(String userid, String lawerid) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        try{
            userService.addFavo(userid, lawerid);
            map.put("status",1);
        }catch (Exception e){
            map.put("status",0);
        }
        return map;
    }

    @GET
    @Path("/getCode/{phone}")
    @Produces("application/json;charset=utf-8")
    @Consumes("application/json;charset=utf-8")
    public HashMap<String,Object> getCode(@PathParam("phone") String phone){
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            String code = userService.getCode(phone);
            System.out.println("================"+code);
            if(code!=null){
                String md5Code = MD5Utils.getMd5Code(phone);
                jedis.set(md5Code, code);
               jedis.expire(md5Code,30);
            }
            map.put("status",1);
        } catch (Exception e) {
            map.put("satus",0);
        }
        return map;
    }


    @POST
    @Path("/addUser")
    @Produces("application/json;charset=utf-8")
    @Consumes("application/json;charset=utf-8")
    public HashMap<String,Object> addUser(String phone,String code){
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            String md5Code = MD5Utils.getMd5Code(phone);
            String s = jedis.get(md5Code);
            if(code.equalsIgnoreCase(s)){
                User user = userService.addUser(phone);
                map.put("status",1);
                map.put("success",user);
            }else{
                map.put("status",0);
            }
        } catch (Exception e) {
            map.put("status",0);
        }
        return map;
    }

    //添加心意
    @POST
    @Path("/addRed")
    @Produces("application/json;charset=utf-8")
    @Consumes("application/json;charset=utf-8")
    public HashMap<String,Object> addRed(Redpackage redpackage){
        HashMap<String, Object> map = new HashMap<String, Object>();
        try{
            userService.addRed(redpackage);
            map.put("status",1);
        }catch (Exception e){
            map.put("status",0);
        }
        return map;
    }

    /**
     * 案例类别模块
     */

    @GET
    @Path("/showAllDealType")
    @Produces("application/json;charset=utf-8")
    public HashMap<String, Object> showAllDealType() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        try{
            List<Dealtype> dealtypes = dealtypeService.queryAll();
            map.put("status",1);
            map.put("success",dealtypes);
        }catch (Exception e){
            map.put("status",0);
        }
        return map;
    }



    //展示所有一级类别下的所有案例以及所有二级类别 和二级类别案例
    @GET
    @Path("/showByOneId/{id}")
    @Produces("application/json;charset=utf-8")
    @Consumes("application/json;charset=utf-8")
    public HashMap<String,Object> showByOneId(@PathParam("id") String id){
        HashMap<String, Object> map = new HashMap<String, Object>();
        try{
            Dealtype dealtype = dealtypeService.queryByOneId(id);
            map.put("status",1);
            map.put("success",dealtype);
        }catch (Exception e){
            map.put("status",0);
        }
        return map;
    }


    //展示所有一级类别下的所有案例以及所有二级类别 和二级类别案例
    @GET
    @Path("/showByTwoId/{id}")
    @Produces("application/json;charset=utf-8")
    @Consumes("application/json;charset=utf-8")
    public HashMap<String,Object> showByTwoId(@PathParam("id") String id){
        HashMap<String, Object> map = new HashMap<String, Object>();
        try{
            Dealtype dealtype = dealtypeService.queryByTwoId(id);
            map.put("status",1);
            map.put("success",dealtype);
        }catch (Exception e){
            map.put("status",0);
        }
        return map;
    }


    //根据id展示案例
    @GET
    @Path("/showOneDeal/{id}")
    @Produces("application/json;charset=utf-8")
    @Consumes("application/json;charset=utf-8")
    public HashMap<String,Object> showOneDeal(@PathParam("id") String id){
        HashMap<String, Object> map = new HashMap<String, Object>();
        try{
            Deal deal = dealService.selectById(id);
            map.put("status",1);
            map.put("success",deal);
        }catch (Exception e){
            map.put("status",0);
        }
        return map;
    }



    /**
     * 律师类别
     */
    @GET
    @Path("/showAllLawertypes")
    @Produces("application/json;charset=utf-8")
    public HashMap<String,Object> showAllLawertypes(){
        HashMap<String, Object> map = new HashMap<String, Object>();
        try{
            List<Lawertype> lawertypes = lawertypeService.queryLawertypes();
            map.put("status",1);
            map.put("success",lawertypes);
        }catch (Exception e){
            map.put("status",0);
        }
        return map;
    }

    //展示某类别下的所有律师
    @GET
    @Path("/showByLawertypeid/{lawertypeid}")
    @Produces("application/json;charset=utf-8")
    @Consumes("application/json;charset=utf-8")
    public HashMap<String,Object> showByLawertypeid(@PathParam("lawertypeid") String lawertypeid){
        HashMap<String, Object> map = new HashMap<String, Object>();
        try{
            Lawertype lawertype = lawertypeService.selectByLawertypeid(lawertypeid);
            map.put("status",1);
            map.put("success",lawertype);
        }catch (Exception e){
            map.put("status",0);
        }
        return map;
    }



}
