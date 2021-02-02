package com.eclouds.tech.Proxy.jdkproxy.service;

import com.eclouds.tech.notransaction.server.AccountByNoTransactionService;
import com.eclouds.tech.util.TxUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class JdkProxyFactory {
    @Autowired
    @Qualifier("accountServiceByNoTransactionImpl")
    private AccountByNoTransactionService accountServiceByNoTransaction;
    @Autowired
    private TxUtils txUtils;

    @Bean
    public AccountByNoTransactionService createJdkProxyAccountService() {
        return (AccountByNoTransactionService)
                Proxy.newProxyInstance(accountServiceByNoTransaction.getClass().getClassLoader(),
                        accountServiceByNoTransaction.getClass().getInterfaces(),
                        new InvocationHandler() {
                            @Override
                            public Object invoke(Object proxy, Method method, Object[] args) throws
                                    Throwable {
                                Object obj = null;
                                try {
                                    //开启事务
                                    txUtils.openTx();
                                    obj = method.invoke(accountServiceByNoTransaction, args);
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