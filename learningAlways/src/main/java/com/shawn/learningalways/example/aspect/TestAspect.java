package com.shawn.learningalways.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @ClassName: TestAspect
 * @Description 配合自定义注解的切面类
 * @author: Shawn Wu
 * @date: 2019/5/6 11:40
 * @version:
 */
@Aspect
@Component
public class TestAspect {

    @Around(value = "@annotation(com.shawn.learningalways.example.annotation.TestAnnotation)")
    public Object managerAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("这个方法加了一个自定义注解");
        return null;
    }
}