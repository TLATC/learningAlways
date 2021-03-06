package com.shawn.learningalways.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 系统名称: learningAlways
 * 模块名称: 测试模块
 * 类 名 称: WebLogAspect
 * 软件版权: shawn
 * 功能说明：切面类
 * 系统版本：v1.0.1
 * 开发人员: shawn
 * 开发时间: 2018/7/10 22:41
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
@Aspect //将一个java类定义为切面类
@Order(5) //优先级为5
@Component
public class WebLogAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebLogAspect.class);

    /**
     * 本地线程变量，记录开始时间（防止同步问题）
     */
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    /**
     * 指定切点
     */
    @Pointcut("execution(public * com.shawn.learningalways.example.controller..*.*(..))")
    public void webLog(){}

    /**
     * 切入点开始处切入内容
     * @param joinPoint
     * @throws Throwable
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable{
        startTime.set(System.currentTimeMillis());
        // 在切入点前的操作，按order的值由小到大执行
//        LOGGER.debug("用切面在方法执行前的打印，本切面类优先级为5");
    }

    /**
     * 在切入点return内容之后切入内容
     * @param ret
     * @throws Throwable
     */
    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable{
//        LOGGER.debug("用切面在方法执行后的打印，方法返回值是：" + ret);
//        LOGGER.debug("本方法的耗时是：" + (System.currentTimeMillis()-startTime.get()));
        // 在切入点后的操作，按order的值由大到小执行
//        LOGGER.debug("本切面类优先级为5");
    }

}
