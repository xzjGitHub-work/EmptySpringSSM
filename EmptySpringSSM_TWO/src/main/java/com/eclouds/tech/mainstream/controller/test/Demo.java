package com.eclouds.tech.mainstream.controller.test;

import com.eclouds.tech.mainstream.server.AccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: 测试类
 * @Author: xzj
 * @CreateDate: 2021/2/2 11:17
 */
public class Demo {
    @Test
    public void test01(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/springApplication.xml");
        AccountService accountService = context.getBean(AccountService.class);
        accountService.transfer("小明","小红",10D);
    }
}
