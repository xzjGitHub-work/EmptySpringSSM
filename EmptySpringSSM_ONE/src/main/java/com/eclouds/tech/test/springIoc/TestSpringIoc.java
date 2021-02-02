package com.eclouds.tech.test.springIoc;

import com.eclouds.tech.test.factory.TestBean;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: 测试使用Spring的工厂模式实例化bean
 * @Author: xzj
 * @CreateDate: 2021/2/2 10:05
 */
public class TestSpringIoc {
    @Test
    public void test01() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/springBean.xml");
        TestBean bean = (TestBean) context.getBean("TestBean");
        bean.name = "许兆举";
        System.out.println(bean.name);
        System.out.println(bean.Perform());
        testIsSingleton(bean);
    }

    public void testIsSingleton(TestBean testBean){
        System.out.println(testBean.name);

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/springBean.xml");
        TestBean bean = (TestBean) context.getBean("TestBean");
        System.out.println("这是第二次从ioc中获取bean========="+bean.name);
    }
}
