package com.ibingbo.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by bing on 17/6/8.
 */
public class People implements BeanNameAware,BeanFactoryAware,ApplicationContextAware,InitializingBean,DisposableBean{
    private String id;
    private String name;
    private Integer age;

    public People() {
        System.out.println("people call constructor...");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        System.out.println("people call set id property");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("people call set name property");
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
        System.out.println("people call set age property");
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("people call BeanFactoryAware.setBeanFactory()");
    }

    public void setBeanName(String name) {
        System.out.println("people call BeanNameAware.setBeanName()");

    }

    public void destroy() throws Exception {
        System.out.println("people call DisposableBean.destroy()");

    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("people call InitializingBean.afterPropertiesSet()");

    }
//
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("people call BeanPostProcessor.postProcessBeforeInitialization()");
//
//        return null;
//    }
//
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("people call BeanPostProcessor.postProcessAfterInitialization()");
//
//        return null;
//    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("people call ApplicationContextAware.setApplicationContext()");

    }

    public void init() {
        System.out.println("people call init()");
    }

    public void myDestroy() {
        System.out.println("people call myDestroy()");
    }
}
