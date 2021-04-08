package com.yc.biz;

import com.yc.AppConfig;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.DependsOn;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@DependsOn("helloWorld")  //强制依赖
public class HelloWorldTest2 {  //测试用例

    @Autowired
    private HelloWorld hw;//默认情况下，所有的bean都是eager(勤快加载)

    @Autowired
    private HelloWorld hw2;

    @Test
    public void testHello() {
       System.out.println("aa");
       System.out.println(hw.hashCode()+"\t"+hw2.hashCode());
    }
}