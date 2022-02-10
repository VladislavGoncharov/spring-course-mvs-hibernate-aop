package com.goncharovvlad.spring_mvc_hibernate_aop.entity.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLoggingAspect {

    @Around("execution(* com.goncharovvlad.spring_mvc_hibernate_aop.entity.dao.*.*(..))")
    public Object allMethodAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        String methodName = methodSignature.getName();

        System.out.println("Start method" + methodName);

        Object targetsMethod = proceedingJoinPoint.proceed();

        System.out.println("End method" + methodName);
        return targetsMethod;
    }
}
