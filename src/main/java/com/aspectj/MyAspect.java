package com.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
//切面
@Aspect
public class MyAspect {
//    //前置通知+切人点
//    @Before(value ="execution(* com.springmvc.mvcController.login(..))")
//    public void before(){
//        System.out.println("前置增强中。。。");
//    }
//
//    @After(value ="execution(* com.springmvc.mvcController.login(..))")
//    public void after(){
//
//        System.out.println("后置增强中。。。");
//    }

    @Around(value ="execution(* com.springmvc.mvcController.login(..))")
    public Object  around(ProceedingJoinPoint jp){
        try {
            System.out.println("环绕增强开始。。。");
            Object result = jp.proceed();
            System.out.println("环绕增强结束。。。");
            return result;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return null;
    }
}
