package com.yc;

import com.yc.bean.HelloWorld;
import com.yc.springframework.stereotype.MyBean;
import com.yc.springframework.stereotype.MyComponentScan;
import com.yc.springframework.stereotype.MyConfiguration;

@MyConfiguration
@MyComponentScan(basePackages={"com.yc.dao","com.yc.biz"})
public class MyAppconfig {

//    @MyBean
//    public HelloWorld hw(){ //method.invoke(MyAppConfig对象，xxx)
//        return new HelloWorld();
//    }

//    @MyBean
//    public HelloWorld hw2(){//method.invoke(MyAppConfig对象，xxx)
//        return new HelloWorld();
//    }

}
