package com.yc.dao;

import com.yc.springframework.stereotype.MyRepository;

import java.util.Random;

@MyRepository  //异常转化：从Exception 转为 RuntimeException
public class StudentDaoMybatisImpl implements StudentDao{

    @Override
    public int add(String name) {
        {
            System.out.println("mybatis 添加学生:"+name);
            Random r=new Random();
            return r.nextInt();
        }
    }

    @Override
    public void update(String name) {
        System.out.println("mybatis 更新学生:"+name);
    }
}
