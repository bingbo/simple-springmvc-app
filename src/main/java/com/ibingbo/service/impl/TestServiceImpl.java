package com.ibingbo.service.impl;

import org.springframework.stereotype.Service;

import com.ibingbo.service.TestService;

/**
 * Created by bing on 17/7/18.
 */
@Service
public class TestServiceImpl implements TestService{
    public void test(String name) {
        System.out.println("test " + name);
    }
}
