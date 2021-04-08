package com.yc.biz;

import com.yc.dao.StudentDao;

import com.yc.dao.StudentDaoJpaImpl;
import com.yc.springframework.stereotype.MyAutowired;
import com.yc.springframework.stereotype.MyService;


@MyService //给spring的类的托管
public class StudentBizImpl {

    private StudentDao studentDao;

    public StudentBizImpl(StudentDao studentDao){
        this.studentDao=studentDao;
    }

    public StudentBizImpl(){
    }

    public StudentDao getStudentDao(){
        return studentDao;
    }

    //@Inject   //javax中的依赖注入，如果有多个对象(比如这里有 StudentDaoJpaImpl和StudentDaoMybatisImpl对象)
    //因为有多个对象可以注入，所以这里必须用@Named("studentDaoJpaImpl"),如果只有一个对象，则不惜要写
    @MyAutowired  //org.springframework
    //@MyQualifier("studentDaoJpaImpl")  //如果有多个对象(比如这里有 StudentDaoJpaImpl和StudentDaoMybatisImpl对象)
    //因为有多个对象可以注入，所以这里必须用@Qualifier("studentDaoJpaImpl"),如果只有一个对象，则不惜要写
   // @MyResource(name="studentDaoJpaImpl")
    public void setStudentDao(StudentDao studentDao){
        this.studentDao=studentDao;
    }

    public int add(String name){
        System.out.println("=====业务层====");
        System.out.println("用户名是否重名");
        int result=studentDao.add(name);
        System.out.println("=====业务层操作结束======");
        return result;
    }

    public void update(String name){
        System.out.println("=====业务层====");
        System.out.println("用户名是否重名");
        studentDao.update(name);
        System.out.println("=====业务层操作结束======");
    }

}
