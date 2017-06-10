package com.ibingbo.namespacehandler;

import com.ibingbo.beandefinitionparser.PeopleBeanDefinitionParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created by bing on 17/6/8.
 */
public class MyNamespaceHandler extends NamespaceHandlerSupport{
    public void init() {
        this.registerBeanDefinitionParser("people", new PeopleBeanDefinitionParser());
    }
}
