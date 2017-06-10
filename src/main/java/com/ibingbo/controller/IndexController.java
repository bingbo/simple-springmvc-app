package com.ibingbo.controller;

import com.ibingbo.bean.People;
import com.ibingbo.rpc.spring.bean.ReferenceBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by bing on 17/6/6.
 */
@Controller
public class IndexController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private People people;
    @Autowired
    private ReferenceBean referenceBean;

    @Value(value = "#{bill.name}")
    private String name;


    @ResponseBody
    @RequestMapping("/index")
    public String index() {
        LOGGER.debug("*************** {} *************", "/index");
        LOGGER.info("********id:{}*********name:{}**********age:{}", people.getId(), people.getName(), people.getAge());
        LOGGER.info("*********@value name:{}**********", name);
        return "hello,index";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}