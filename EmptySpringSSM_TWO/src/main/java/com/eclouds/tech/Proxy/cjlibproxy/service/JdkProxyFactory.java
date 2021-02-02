package com.eclouds.tech.Proxy.cjlibproxy.service;

import com.eclouds.tech.notransaction.server.AccountByNoTransactionService;
import com.eclouds.tech.traditional.util.TxUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class JdkProxyFactory {
//1.15【AOP事务版】cglib动态代理实现事务增强
    @Autowired
    @Qualifier("AccountByNoTransactionServiceImpl")
    private AccountByNoTransactionService accountService;
    @Autowired
    private TxUtils txUtils;

    @Bean
    public AccountByNoTransactionService createJdkProxyAccountService() {
        return (AccountByNoTransactionService)
                Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                        accountService.getClass().getInterfaces(),
                        new InvocationHandler() {
                            @Override
                            public Object invoke(Object proxy, Method method, Object[] args) throws
                                    Throwable {
                                Object obj = null;
                                try {
                                    //开启事务
                                    txUtils.openTx();
                                    obj = method.invoke(accountService, args);
                                    //提交事务
                                    txUtils.commitTx();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    txUtils.rollbackTx();
                                } finally {
                                    txUtils.closeTx();
                                }
                                return obj;
                            }
                        });
    }
}