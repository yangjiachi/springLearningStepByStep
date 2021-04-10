package com.yc;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Date;

public class LogAspectCglib implements MethodInterceptor {

    private Object target;

    public LogAspectCglib(Object target){
        this.target=target;
    }

    public Object createProxy(){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass( this.target.getClass() );
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
//        System.out.println("代理类对象:"+o.getClass());
//        System.out.println("方法:"+method);
//        System.out.println("方法中的参数:"+args);
//        System.out.println("可以代理的方法:"+methodProxy);

        if(method.getName().startsWith("add")){ //转换成切入点表达式的解析->AspectJ的切入点表达式
            //前置增强
            log();
        }
        Object returnValue=method.invoke(this.target,args);
        return returnValue;
    }

    private void log(){
        System.out.println("=======before advice========");
        System.out.println("hello,this is"+new Date());
        System.out.println("============");
    }
}
