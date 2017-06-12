package com.ibingbo;

import com.ibingbo.bean.People;
import com.ibingbo.service.HelloService;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by bing on 17/6/12.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"/spring.xml"})
public class BeanTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        People people = context.getBean(People.class);
        Object service = context.getBean("helloService");
        service = (HelloService) service;
        System.out.println(service);
    }

}
