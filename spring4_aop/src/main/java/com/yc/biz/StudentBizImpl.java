package com.yc.biz;

import com.yc.dao.StudentDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service //给spring的类的托管
public class StudentBizImpl implements StudentBiz{

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
   // @Resource(name="studentDaoJpaImpl")    //如果没有找到同名的托管bean，则按类型查找托管bean  （先找studentDao 的bean，结果没找到，就退化成按照类型找，找到两个，崩了）
    public void setStudentDao(StudentDao studentDao){
        this.studentDao=studentDao;
    }

    public int add(String name){
        System.out.println("=====add业务层====");
        System.out.println("用户名是否重名");
        int result=studentDao.add(name);
        System.out.println("=====add业务层操作结束======");
        return result;
    }

    public void update(String name){
        System.out.println("=====update业务层====");
        System.out.println("用户名是否重名");
        studentDao.update(name);
        System.out.println("=====update业务层操作结束======");
    }

    public void find(String name){
        System.out.println("=====find业务层====");
        System.out.println("业务层查找用户名"+name);
        studentDao.find(name);
        System.out.println("=====find业务层操作结束======");

    }

}
