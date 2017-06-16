package com.baizhi.advice;


import com.baizhi.annotation.RedisAnnotation;
import com.baizhi.util.MD5Utils;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.SerializationUtils;
import redis.clients.jedis.Jedis;


/**
 * Created by SY on 2017/6/7.
 */
public class RedisAdvice implements MethodInterceptor {

    @Autowired
    private Jedis jedis;

    public Object invoke(MethodInvocation invocation) throws Throwable {
        //获取类的全限定名
        String className = invocation.getMethod().getDeclaringClass().getName();
        String md5Code = MD5Utils.getMd5Code(className);
        byte[] bytes = md5Code.getBytes();



        //
        if(invocation.getMethod().isAnnotationPresent(RedisAnnotation.class)){
            //获取方法名
            String methodName = invocation.getMethod().getName();

            //获取参数 实参
            String cs="";
            for(int i=0;i<invocation.getArguments().length;i++){
                cs += invocation.getArguments()[i];
            }


            //MD5操作
            String methodCs = MD5Utils.getMd5Code(methodName + cs);
            String key = methodCs+md5Code;
            byte[] keySerialize1 = SerializationUtils.serialize(key);

            //如果键存在缓存
            if(jedis.hexists(bytes,keySerialize1)){
                //if(jedis.exists(keySerialize1)){
                Object deserialize = SerializationUtils.deserialize(jedis.hget(bytes,keySerialize1));
                System.out.println("键存在~~~");
                //Object proceed = invocation.proceed();
                return deserialize;
            }else{//键不存在缓存
                System.out.println("键不存在~~~");
                Object proceed = invocation.proceed();
                byte[] serialize = SerializationUtils.serialize(proceed);
                jedis.hset(bytes,keySerialize1,serialize);
                return proceed;
            }
        }
        else{//没有注解
            System.out.println("没有注解。。。删除缓存~~");

            jedis.del(md5Code);

            Object proceed = invocation.proceed();
            return proceed;
        }


    }
}
