package com.eclouds.tech.test;

import com.eclouds.tech.server.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: 作用描述
 * @Author: xzj
 * @CreateDate: 2021/2/2 16:21
 */
public class demo {
    /**
     * @describe:使用四大通知做
     *
     * @author:xzj
     * @createDate:2021/2/2 16:26
     * @param:[args]
     * @return:void
     */
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springApplication.xml");
        UserService bean = context.getBean(UserService.class);
        bean.save();
    }
}
