package com.jones.myspringboot.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 系统名称: mySpringBoot
 * 模块名称:
 * 类 名 称: WebLogAspect
 * 软件版权: Jones
 * 功能说明：
 * 系统版本：v1.0.1
 * 开发人员: Jones
 * 开发时间: 2018/7/10 22:41
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
@Aspect //将一个java类定义为切面类
@Component
public class WebLogAspect {

    @Pointcut("execution(public * com.jones.myspringboot.example.controller..*.*(..))")
    public void webLog(){}

    @Before("webLog()") //切入点开始处切入内容
    public void doBefore(JoinPoint joinPoint) throws Throwable{
        System.out.println("用切面在方法前的打印");
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()") //在切入点return内容之后切入内容
    public void doAfterReturning(Object ret) throws Throwable{
        System.out.println("用切面在方法前的打印"+ret.toString());
    }


}
