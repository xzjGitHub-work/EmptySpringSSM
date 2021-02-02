package com.eclouds.tech.traditional.server.impl;

import com.eclouds.tech.model.Account;
import com.eclouds.tech.traditional.dao.AccountDaoTraditional;
import com.eclouds.tech.traditional.server.AccountByTraditionalService;
import com.eclouds.tech.traditional.util.TxUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountByTraditionalServiceImpl implements AccountByTraditionalService {
    @Autowired
    private AccountDaoTraditional accountDao;
    @Autowired
    private TxUtils txUtils;

    @Override
    public void transfer(String fromUser, String toUser, Double money) {
        new TxUtils();
        try {
            //开启事务
            txUtils.openTx();
            //查询出转账双方的账户
            Account fromAccount = accountDao.findByName(fromUser);
            Account toAccount = accountDao.findByName(toUser);
            //修改双方的金额
            fromAccount.setBalance(fromAccount.getBalance() - money);
            toAccount.setBalance(toAccount.getBalance() + money);
            //更新双方的账户
            accountDao.update(fromAccount);
            int i = 1 / 0;
            accountDao.update(toAccount);
            //提交事务
            txUtils.commitTx();
        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            txUtils.rollbackTx();
        } finally {
            //关闭事务
            txUtils.closeTx();
        }
    }
}