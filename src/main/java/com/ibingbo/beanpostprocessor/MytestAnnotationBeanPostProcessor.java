package com.ibingbo.beanpostprocessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;

/**
 * Created by bing on 17/6/9.
 */
public class MytestAnnotationBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter implements BeanFactoryAware{
    private final Logger logger = LoggerFactory.getLogger(MytestAnnotationBeanPostProcessor.class);
    private ConfigurableListableBeanFactory beanFactory;

    @Override
    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
        return super.determineCandidateConstructors(beanClass, beanName);
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        System.out.println(beanName);

        return super.postProcessPropertyValues(pvs, pds, bean, beanName);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return super.postProcessAfterInitialization(bean, beanName);
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        if (beanFactory instanceof ConfigurableListableBeanFactory)
        this.beanFactory = (ConfigurableListableBeanFactory)beanFactory;
    }
}
