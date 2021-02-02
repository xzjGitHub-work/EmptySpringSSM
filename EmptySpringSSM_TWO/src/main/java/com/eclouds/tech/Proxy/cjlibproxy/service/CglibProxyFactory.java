//package com.eclouds.tech.Proxy.jdkproxy.service;
//
//import com.eclouds.tech.notransaction.server.AccountByNoTransactionService;
//import com.eclouds.tech.util.TxUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.cglib.proxy.Enhancer;
//import org.springframework.cglib.proxy.MethodInterceptor;
//import org.springframework.cglib.proxy.MethodProxy;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
//import java.lang.reflect.Method;
//
//@Component
//public class CglibProxyFactory {
//    @Autowired
//    @Qualifier("accountServiceByNoTransactionImpl")
//    private AccountByNoTransactionService accountService;
//    @Autowired
//    private TxUtils txUtils;
//
//    @Bean
//    public AccountByNoTransactionService createCglibProxyAccountService() {
//            //参数一：目标对象的类型
//            //参数二：动作类
//        return (AccountByNoTransactionService) Enhancer.create(accountService.getClass(), new
//                MethodInterceptor() {
//                    /**
//                     * 前三个参数和jdk动态代理里面的是一样的
//                     * @param proxy
//                     * @param method
//                     * @param args
//                     * @param methodProxy 增强后的方法
//                     */
//                    @Override
//                    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy
//                            methodProxy) throws Throwable {
//                        Object obj = null;
//                        try {
//                            //开启事务
//                            txUtils.openTx();
//                            obj = method.invoke(accountService, args);
//                            //提交事务
//                            txUtils.commitTx();
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                            txUtils.rollbackTx();
//                        } finally {
//                            txUtils.closeTx();
//                        }
//                        return obj;
//                    }
//                });
//    }
//}