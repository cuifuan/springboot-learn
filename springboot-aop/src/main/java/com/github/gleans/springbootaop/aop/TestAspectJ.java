package com.github.gleans.springbootaop.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Aspect
@Configuration
public class TestAspectJ {

    // 前置通知
    @Before("execution(* com.github.gleans.springbootaop.controller..*(..))")
    public void before(JoinPoint joinPoint) {
        // 通知
        log.info("前置通知测试");
        log.info(" 当前节点：{}", joinPoint);
    }

    // 后置通知
    @After("execution(* com.github.gleans.springbootaop.controller..*(..))")
    public void after(JoinPoint joinPoint) {
        // 通知
        log.info("后置通知测试,当前节点：{}", joinPoint);
    }

    // 环绕通知
    @Around("execution(* com.github.gleans.springbootaop.controller..*(..))")
    public Object handlerControllerMethod(ProceedingJoinPoint joinPoint) {
        long startTime = System.currentTimeMillis();
        Object res = null;
        try {
            res = joinPoint.proceed();
        } catch (Throwable throwable) {
            log.error("出错了:{}", throwable.getLocalizedMessage());
        }

        log.info(joinPoint.getSignature() + "=耗时:=" + (System.currentTimeMillis() - startTime));

        return res;
    }


    //也可以定义切入点
    @Pointcut(value = "execution(* com.github.gleans.springbootaop.controller..*(..))")
    public void testAfterReturing(){};

    // 正常返回通知
    @AfterReturning(value = "testAfterReturing()", returning = "res")
    public Object afterReturning(String res) {
        // 通知
        log.info("正常返回通知测试,返回值:{}", res);
        return "222";
    }

    @AfterThrowing(value = "testAfterReturing()", throwing="ex")
    public void AfterThrowing(JoinPoint jp, Throwable ex) {
        log.info("=====异常返回通知====:{}", ex.getLocalizedMessage());
    }

}
