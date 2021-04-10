package com.yc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect //切面类：你要增强的功能
@Component //IOC注解，以实现让spring托管的功能
@Order(value = 1)
public class Log3Aspect {

    @Around("execution(* com.yc.biz.StudentBizImpl.find*(..))")
    private Object compute2(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("********compute2********进入到增强了。。。");
        long start=System.currentTimeMillis();
        Object retVal=pjp.proceed();
        long end=System.currentTimeMillis();
        System.out.println("********compute2********要退出增强了。。。");
        System.out.println("这个方法的运行时长为:"+(end-start));
        return retVal;
    }
}
