package com.ibingbo.service.impl;

import com.ibingbo.annotation.MyRemoteService;
import com.ibingbo.rpc.common.annotation.RpcService;
import com.ibingbo.service.HelloService;

/**
 * Created by bing on 17/6/10.
 */
@RpcService(HelloService.class)
@MyRemoteService(name = "test")
public class HelloServiceImpl implements HelloService{
    public String hello(String name) {
        return "hello, " + name;
    }
}
