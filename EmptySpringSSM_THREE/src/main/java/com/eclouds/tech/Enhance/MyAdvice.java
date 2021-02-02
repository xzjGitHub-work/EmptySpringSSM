package com.eclouds.tech.Enhance;

import org.springframework.stereotype.Component;

/**
 * @describe:增强类
 *
 * @author:xzj
 * @createDate:2021/2/2 15:44
 * @param:
 * @return:
 */
@Component
public class MyAdvice {
    //前置通知，就是在切入点方法前执行
    public void before() {
        System.out.println("前置通知！");
    }

    //后置通知，就是在切入点方法后执行
    public void afterReturning() {
        System.out.println("后置通知！");
    }

    //异常通知，就是在切入点方法出错时执行
    public void afterThrowing() {
        System.out.println("异常通知！");
    }

    //最终通知，就是在切入点方法执行完毕，不管成功与否
    public void after() {
        System.out.println("最终通知！");
    }
}