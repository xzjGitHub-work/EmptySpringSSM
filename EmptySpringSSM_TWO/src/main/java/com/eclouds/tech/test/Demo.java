package com.eclouds.tech.test;

import com.eclouds.tech.notransaction.server.AccountByNoTransactionService;
import com.eclouds.tech.traditional.server.AccountByTraditionalService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: 测试类
 * @Author: xzj
 * @CreateDate: 2021/2/2 11:17
 */
public class Demo {
    /**
     * @describe:测试直接使用IOC获取对象不添加事务
     *
     * @author:xzj
     * @createDate:2021/2/2 13:50
     * @param:[]
     * @return:void
     * 当代码中有异常导致代码不能继续执行，会将未提交的事务提交
     */
    @Test
    public void test01(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/springApplication.xml");
        AccountByNoTransactionService accountServiceByNoTransaction = context.getBean(AccountByNoTransactionService.class);
        accountServiceByNoTransaction.transfer("小明","小红",10D);
    }
    /**
     * @describe:手动编写事务逻辑
     *
     * @author:xzj
     * @createDate:2021/2/2 13:51
     * @param:[]
     * @return:void
     * 有事务的处理，当代码中有异常出现会将出现异常的代码之前的事务回滚
     */
    @Test
    public void test02(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/springApplication.xml");
        AccountByTraditionalService accountService = context.getBean(AccountByTraditionalService.class);
        accountService.transfer("小明","小红",10D);
    }
}
