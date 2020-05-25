package com.shawn.learningalways.springlearn;

import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * CircularDependency
 * 模拟spring解决循环依赖的问题
 *
 * @author Shawn Wu
 * @date 2020/5/25 14:29
 * @since x
 */
public class CircularDependency {
    private static final Logger LOGGER = LoggerFactory.getLogger(CircularDependency.class);

    /**
     * 缓存大致的Bean信息，作用于Spring的earlySingletonObjects类似
     * 其中，key为beanName，value为Bean的实例
     */
    private static Map<String, Object> earlySingletonObjects = new HashMap<>(2);


    /**
     * 获取指定类的实例（单例模式）
     *
     * @param beanClass 指定的类
     * @return 指定类的实例
     * @date 2020/5/25 15:05
     * @author Shawn Wu
     */
    @SneakyThrows
    private static <T> T getBean(Class<T> beanClass){
        // 假设存储的bean名字都是小写
        String beanName = beanClass.getSimpleName().toLowerCase();
        // 如果缓存map中已经存在bean的实例，则直接返回
        if(earlySingletonObjects.containsKey(beanName)){
            return (T) earlySingletonObjects.get(beanName);
        }

        // 通过构造方法，获取bean的实例
        Object object = beanClass.getDeclaredConstructor().newInstance();
        // 在给bean实例赋值之前，就提前将实例放入缓存map中
        earlySingletonObjects.put(beanName, object);
        /*
         * 把属性注入到类实例中
         * 因为这里是为了模拟spring解决循环依赖，故此简化的认为类中属性只有其他类
         */
        Field[] fields = object.getClass().getDeclaredFields();
        for(Field field:fields){
            field.setAccessible(true);
            // 获取需要注入字段的class
            Class<?> fieldClass = field.getType();
            String fieldBeanName = fieldClass.getSimpleName().toLowerCase();
            // 如果缓存map中有依赖的bean，则直接注入；若没有，则递归注入
            field.set(object, earlySingletonObjects.containsKey(fieldBeanName)
                ? earlySingletonObjects.get(fieldBeanName): getBean(fieldClass));
        }

        return (T) object;
    }

    public static void main(String[] args) {
        // 假设spring扫描到了A、B两个类
        Class[] classes = {ClassA.class, ClassB.class};
        // 模拟spring，依次实例化扫描到的类
        for(Class aClass:classes){
            getBean(aClass);
        }

        // 模拟spring实例化完成后，从上下文中获取实例
        ClassA classA = getBean(ClassA.class);
        ClassB classB = getBean(ClassB.class);
        LOGGER.info("模拟spring实例化完成后，获取classA及其属性是否正常：{}", classA.getB() == classB);
        LOGGER.info("模拟spring实例化完成后，获取classB及其属性是否正常：{}", classB.getA() == classA);
    }
}