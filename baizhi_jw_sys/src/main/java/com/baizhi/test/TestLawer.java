package com.baizhi.test;

import com.baizhi.dao.LawerMapper;
import com.baizhi.entity.Lawer;
import com.baizhi.service.LawerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by SY on 2017/6/12.
 */
public class TestLawer {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-basic.xml");
        LawerService lawerService = (LawerService) context.getBean("lawerService");

        //展示一个律师
        Lawer lawer = lawerService.queryOne("1");
        System.out.println(lawer);

        //展示所有律师
        /*List<Lawer> lawers = lawerMapper.selectAll();
        for (Lawer lawer : lawers) {
            System.out.println(lawer);
        }*/

    }

}
