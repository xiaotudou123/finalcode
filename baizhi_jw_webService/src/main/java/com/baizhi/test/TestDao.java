package com.baizhi.test;

import com.baizhi.dao.DealtypeMapper;
import com.baizhi.dao.LawerMapper;
import com.baizhi.dao.LawertypeMapper;
import com.baizhi.entity.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by SY on 2017/6/15.
 */
public class TestDao {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-basic.xml");
        //LawerMapper lawerMapper = (LawerMapper) context.getBean("lawerMapper");
        /*List<Lawer> lawers = lawerMapper.selectAll();
        for (Lawer lawer : lawers) {
            System.out.println(lawer);
            for (Redpackage redpackage : lawer.getRedpackages()) {
                System.out.println(redpackage);
            }
        }*/

        /*Lawer lawer = lawerMapper.selectByPrimaryKey("3");
        System.out.println(lawer);
        System.out.println("==============");
        for (Redpackage redpackage : lawer.getRedpackages()) {
            System.out.println(redpackage);
        }
        System.out.println("===========");
        for (Lawertype lawertype : lawer.getLawertypes()) {
            System.out.println(lawertype);
        }
        System.out.println("===========");
        for (Comment comment : lawer.getComments()) {
            System.out.println(comment);
        }*/

       /* LawertypeMapper lawertypeMapper = (LawertypeMapper) context.getBean("lawertypeMapper");
        Lawertype lawertype = lawertypeMapper.selectByLawertypeid("2");
        for (Lawer lawer : lawertype.getLawers()) {
            System.out.println(lawer);
        }*/
        DealtypeMapper dealtypeMapper = (DealtypeMapper) context.getBean("dealtypeMapper");
        Dealtype dealtype = dealtypeMapper.selectByTwoId("7");

        for (Deal deal : dealtype.getDeals()) {
            System.out.println("===============");
            System.out.println(deal);
        }



    }
}
