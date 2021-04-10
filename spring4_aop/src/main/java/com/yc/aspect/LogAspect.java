package com.yc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect //切面类：你要增强的功能
@Component //IOC注解，以实现让spring托管的功能
@Order(value = 100)
public class LogAspect {
    //切入点的声明
    @Pointcut("execution(* com.yc.biz.StudentBizImpl.add*(..))") //切入点表达式：哪些方法上加增强
    private void add(){

    }

    @Pointcut("execution(* com.yc.biz.StudentBizImpl.update*(..))") //切入点表达式：哪些方法上加增强
    private void update(){

    }

    //合并两个方法
    @Pointcut("add()||update()")
    private void addAndUpdate(){

    }

    //增加声明
    //@Before("com.yc.aspect.LogAspect.addAndUpdate()")
    public void log(){
        System.out.println("=========前置增强日志=========");
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dstr=sdf.format(d);
        System.out.println("执行时间为:"+dstr);
        System.out.println("=========前置增强日志结束=========");

    }

   // @After("com.yc.aspect.LogAspect.addAndUpdate()")
    private void bye(JoinPoint jp){
        System.out.println("**********bye bye**********");
        //连接点中的所有信息
        Object target=jp.getTarget();
        System.out.println("目标类为:"+target);
        System.out.println("方法:"+jp.getSignature());
        Object[] objs=jp.getArgs();
        if(objs!=null){
            for (Object o:objs){
                System.out.println("参数:"+o);
            }
        }
        System.out.println("**********bye bye**********");
    }

    @Around("execution(* com.yc.biz.StudentBizImpl.find*(..))")
    private Object compute(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("========compute1========进入到增强了。。。");
        long start=System.currentTimeMillis();
        Object retVal=pjp.proceed();
        long end=System.currentTimeMillis();
        System.out.println("========compute1========要退出增强了。。。");
        System.out.println("这个方法的运行时长为:"+(end-start));
        return retVal;
    }

//    @Around("execution(* com.yc.biz.StudentBizImpl.find*(..))")
//    @Order(value = 99)
//    private Object compute2(ProceedingJoinPoint pjp) throws Throwable{
//        System.out.println("********compute2*********进入到增强了。。。");
//        long start=System.currentTimeMillis();
//        Object retVal=pjp.proceed();
//        long end=System.currentTimeMillis();
//        System.out.println("********compute2*********要退出增强了。。。");
//        System.out.println("这个方法的运行时长为:"+(end-start));
//        return retVal;
//    }


    //切入点表达式的语法:  ?代表出现0次或1次
//    modifiers-pattern:修饰符
//    ret-type-pattern:返回类型
//    declaring-type-pattern:
//    name-pattern:名字模型
//    throws-pattern
//    execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(parameter-pattern)
//                throws-pattern?)

}
