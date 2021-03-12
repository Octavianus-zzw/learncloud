package com.zzw.test.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomLogAspect {
    @Pointcut(value = "execution(public * com.zzw.test.controller.AopTestController.aopTest())")
    public void pointcutLog() {}

    @Before("pointcutLog()")
    public void before(JoinPoint joinPoint) {
        System.out.println("aop before");
    }

    @AfterReturning(returning = "obj", pointcut = "pointcutLog()")
    public void afterReturning(Object obj) {
        System.out.println("aop after returning");
    }
}
