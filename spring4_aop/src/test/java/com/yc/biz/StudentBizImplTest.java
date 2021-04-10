package com.yc.biz;

import com.yc.MyAppConfig;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MyAppConfig.class)
public class StudentBizImplTest {
    //@Resource   先按名字注入，如不行再按类型注入，此时也不能出现多个同类型的bean
    @Autowired   //按类型注入，如果多个同类托管bean，则报错，要不就加入@Qualifier约定
    private StudentBiz sbi;

    @Test
    public void testAdd() {
        sbi.add("张三");
    }
    @Test
    public void testUpdate() {
        sbi.update("张三");
    }
    @Test
    public void testFind() {
        sbi.find("张三");
    }
}