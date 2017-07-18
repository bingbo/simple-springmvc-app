package com.ibingbo.namespacehandler;

import com.ibingbo.beandefinitionparser.AnnotationConfigBeanDefinitionParser;
import com.ibingbo.beandefinitionparser.AnnotationDrivenBeanDefinitionParser;
import com.ibingbo.beandefinitionparser.PeopleBeanDefinitionParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created by bing on 17/6/9.
 */
public class MysourceNamespaceHandler extends NamespaceHandlerSupport{
    public void init() {
        registerBeanDefinitionParser("annotation-driven", new AnnotationDrivenBeanDefinitionParser());
        registerBeanDefinitionParser("annotation-config", new AnnotationConfigBeanDefinitionParser());
        registerBeanDefinitionParser("people", new PeopleBeanDefinitionParser());

    }
}
