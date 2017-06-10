package com.ibingbo.beandefinitionparser;

import com.ibingbo.beanpostprocessor.MytestAnnotationBeanPostProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.parsing.BeanComponentDefinition;
import org.springframework.beans.factory.parsing.CompositeComponentDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * Created by bing on 17/6/9.
 */
public class AnnotationConfigBeanDefinitionParser implements BeanDefinitionParser {
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        Object source = parserContext.extractSource(element);
        CompositeComponentDefinition componentDefinition = new CompositeComponentDefinition(element.getTagName(), source);
        parserContext.pushContainingComponent(componentDefinition);
        RootBeanDefinition postProcessordef = new RootBeanDefinition(MytestAnnotationBeanPostProcessor.class);
        postProcessordef.setSource(source);
        parserContext.registerBeanComponent(new BeanComponentDefinition(postProcessordef, MytestAnnotationBeanPostProcessor.class.getName()));
        parserContext.popAndRegisterContainingComponent();
        return null;
    }
}
