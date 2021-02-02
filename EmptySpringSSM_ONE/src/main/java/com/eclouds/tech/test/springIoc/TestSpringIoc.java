package com.eclouds.tech.test.springIoc;

import com.eclouds.tech.test.factory.TestBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: 测试使用Spring的工厂模式实例化bean
 * @Author: xzj
 * @CreateDate: 2021/2/2 10:05
 */
public class TestSpringIoc {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/springBean.xml");
        TestBean bean = (TestBean) context.getBean("TestBean");
        System.out.println(bean.Perform());

    }
}
