package com.ibingbo.service.impl;

import com.ibingbo.annotation.MyRemoteService;
import com.ibingbo.service.RemoteService;

/**
 * Created by bing on 17/7/18.
 */
@MyRemoteService("remoteService")
public class RemoteServiceImpl implements RemoteService{
    public String getName() {
        return "bill";
    }
}
