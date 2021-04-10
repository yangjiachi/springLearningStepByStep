package com.yc;

import com.yc.biz.StudentBiz;
import com.yc.biz.StudentBizImpl;

public class Test {
    public static void main(String[] args) {
        StudentBiz target=new StudentBizImpl(); //spring 进行ioc

        LogAspect la=new LogAspect(target);
        Object obj=la.createProxy();  //obj就是代理对象
       // System.out.println(obj.toString());

        if(obj instanceof StudentBiz){
            StudentBiz sb= (StudentBiz) obj;
            sb.find("张三");  //jvm会感知到sb是一个proxy，jvm就会调用这个proxy中的invoke
            sb.add("李四");
            sb.update("王五");
        }


    }
}
