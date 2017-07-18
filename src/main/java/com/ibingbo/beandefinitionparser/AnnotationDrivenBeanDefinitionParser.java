package com.ibingbo.beandefinitionparser;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.parsing.BeanComponentDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

import com.ibingbo.annotation.MyRemoteServiceHandler;
import com.ibingbo.beanpostprocessor.AutowiredAnnotationBeanPostProcessor;

/**
 * Created by bing on 17/7/17.
 */
public class AnnotationDrivenBeanDefinitionParser implements BeanDefinitionParser{

    public static final String ANNOTATION_PROCESSOR_BEAN_NAME = AutowiredAnnotationBeanPostProcessor.class.getName();
    public static final String REMOTE_SERVICE_HANDLER_BEAN_NAME = MyRemoteServiceHandler.class.getName();

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        Object source = parserContext.extractSource(element);

        // 注册handler
        RootBeanDefinition serviceHanderDef = new RootBeanDefinition(MyRemoteServiceHandler.class);
        serviceHanderDef.setSource(source);
        serviceHanderDef.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
//        parserContext.getRegistry().registerBeanDefinition(REMOTE_SERVICE_HANDLER_BEAN_NAME, serviceHanderDef);
//        parserContext
//                .registerComponent(new BeanComponentDefinition(serviceHanderDef, REMOTE_SERVICE_HANDLER_BEAN_NAME));
        parserContext
                .registerBeanComponent(new BeanComponentDefinition(serviceHanderDef, REMOTE_SERVICE_HANDLER_BEAN_NAME));


        // 注册处理器
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(ANNOTATION_PROCESSOR_BEAN_NAME);
        builder.getRawBeanDefinition().setSource(source);
        builder.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
        parserContext.getRegistry().registerBeanDefinition(ANNOTATION_PROCESSOR_BEAN_NAME, builder.getBeanDefinition());
        BeanDefinitionHolder holder =
                new BeanDefinitionHolder(builder.getBeanDefinition(), ANNOTATION_PROCESSOR_BEAN_NAME);
        parserContext.registerComponent(new BeanComponentDefinition(holder));
        parserContext.registerBeanComponent(new BeanComponentDefinition(builder.getBeanDefinition(),ANNOTATION_PROCESSOR_BEAN_NAME));


        return null;
    }
}
