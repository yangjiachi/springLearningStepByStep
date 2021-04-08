package com.yc;

import com.yc.bean.HelloWorld;
import com.yc.biz.StudentBizImpl;
import com.yc.springframework.context.MyAnnotationConfigApplicationContext;
import com.yc.springframework.context.MyApplicationContext;

public class Test {
    public static void main(String[] args) {
        MyApplicationContext ac=new MyAnnotationConfigApplicationContext(MyAppconfig.class);
//        HelloWorld hw= (HelloWorld) ac.getBean("hw");
//        hw.show();
        StudentBizImpl hw = (StudentBizImpl) ac.getBean("studentBizImpl");
        hw.add("abc");
    }
}
