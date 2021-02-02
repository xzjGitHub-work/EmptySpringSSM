package com.eclouds.tech.notransaction.server.impl;

import com.eclouds.tech.notransaction.dao.AccountDaoNoTransaction;
import com.eclouds.tech.model.Account;
import com.eclouds.tech.notransaction.server.AccountByNoTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @describe:实现类
 * @author:xzj
 * @createDate:2021/2/2 11:12
 * @param:
 * @return:
 */
@Service
public class AccountByNoTransactionServiceImpl implements AccountByNoTransactionService {

    @Autowired
    private AccountDaoNoTransaction accountDao;

    @Override
    public void transfer(String fromUser, String toUser, Double money) {
        //查询出转账双方的账户
        Account fromAccount = accountDao.findByName(fromUser);
        Account toAccount = accountDao.findByName(toUser);
        //修改双方的金额
        fromAccount.setBalance(fromAccount.getBalance() - money);
        toAccount.setBalance(toAccount.getBalance() + money);
        //更新双方的账户
        accountDao.update(fromAccount);
        //模拟异常
        int i=1/0;
        accountDao.update(toAccount);
    }
}