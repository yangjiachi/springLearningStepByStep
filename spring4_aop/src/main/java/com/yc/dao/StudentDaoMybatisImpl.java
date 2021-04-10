package com.yc.dao;

import org.springframework.stereotype.Repository;

import java.util.Random;

@Repository  //异常转化：从Exception 转为 RuntimeException
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

    @Override
    public String find(String name) {
        System.out.println("Mybatis查找"+name);
        return name;
    }
}
