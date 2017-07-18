package com.ibingbo.annotation;

import java.lang.annotation.Annotation;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by bing on 17/7/18.
 */
public class MyRemoteServiceHandler implements Handler, InitializingBean, ApplicationContextAware {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private ApplicationContext applicationContext;

    public void init() {

    }

    public void afterPropertiesSet() throws Exception {
        String[] beanNames = this.applicationContext.getBeanNamesForAnnotation(MyRemoteService.class);
        for (String beanName : beanNames) {
            Class<?> beanType = null;
            try {
                beanType = this.applicationContext.getType(beanName);
                Class[] interfaces = beanType.getInterfaces();
                MyRemoteService serviceAnnotation = beanType.getAnnotation(MyRemoteService.class);
                String value = serviceAnnotation.value();
                this.logger.info("class:{},interface:{},value:{}", beanType, interfaces, value);
            } catch (Exception e) {
                this.logger.error(e.getMessage(), e);
            }
        }

        this.logger.info("afterPropertiesSet execute ....");
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
