package com.shawn.learningalways.base.util;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @ClassName: SpringUtils
 * @Description
 * @author: Shawn Wu
 * @date: 2020/1/18 17:21
 * @version:
 */
@Component
public class SpringUtils implements ApplicationContextAware{

    /**
     * 应用上下文
     */
    private static ApplicationContext applicationContext;

    /**
     * 私有构造方法
     */
    private SpringUtils(){}

    
    /**
     * @Description 上下文赋值
     * @param applicationContext 上下文
     * @return 
     * @date 2020/1/18 17:24
     * @auther Shawn Wu
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtils.applicationContext = applicationContext;
    }

    /**
     * @Description 获取spring上下文
     * @param
     * @return
     * @date 2020/1/18 17:28
     * @auther Shawn Wu
     */
    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    /**
     * @Description 根据类名，获取类的上下文
     * @param beanName 类名
     * @return
     * @date 2020/1/18 17:30
     * @auther Shawn Wu
     */
    public static Object getBean(String beanName){
        if(StringUtils.isEmpty(beanName)){
            return null;
        }
        return applicationContext.getBean(beanName);
    }

    /**
     * @Description 根据beanType获取springBean
     * @param tClass beanType
     * @return
     * @date 2020/1/18 17:31
     * @auther Shawn Wu
     */
    public static <T> T getBeanByType(Class<T> tClass){
        return applicationContext.getBean(tClass);
    }
}