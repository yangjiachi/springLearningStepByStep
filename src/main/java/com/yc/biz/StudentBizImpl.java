package com.yc.biz;

import com.yc.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


import javax.annotation.Resource;

//@Service
public class StudentBizImpl {

    private StudentDao studentDao;

    public StudentBizImpl(StudentDao studentDao){
        this.studentDao=studentDao;
    }

    public StudentBizImpl(){

    }

    //@Inject   //javax中的依赖注入，如果有多个对象(比如这里有 StudentDaoJpaImpl和StudentDaoMybatisImpl对象)
    //因为有多个对象可以注入，所以这里必须用@Named("studentDaoJpaImpl"),如果只有一个对象，则不惜要写
    @Autowired  //org.springframework
    @Qualifier("studentDaoJpaImpl")  //如果有多个对象(比如这里有 StudentDaoJpaImpl和StudentDaoMybatisImpl对象)
    //因为有多个对象可以注入，所以这里必须用@Qualifier("studentDaoJpaImpl"),如果只有一个对象，则不惜要写
    //@Resource(name="studentDaoJpaImpl")
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
        studentDao.add(name);
        System.out.println("=====业务层操作结束======");
    }

}
