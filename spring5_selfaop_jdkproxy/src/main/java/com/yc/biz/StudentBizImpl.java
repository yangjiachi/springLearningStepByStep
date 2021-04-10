package com.yc.biz;

public class StudentBizImpl implements StudentBiz{
    @Override
    public int add(String name) {
        System.out.println("调用了studentBizImpl中的add"+name);
        return 0;
    }

    @Override
    public void update(String name) {
        System.out.println("调用了studentBizImpl中的update"+name);
    }

    @Override
    public String find(String name) {
        System.out.println("调用了studentBizImpl中的find"+name);
        return name+"====";
    }
}
