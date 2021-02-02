package com.eclouds.tech.traditional.dao.impl;

import com.eclouds.tech.model.Account;
import com.eclouds.tech.traditional.dao.AccountDaoTraditional;
import com.eclouds.tech.traditional.util.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class AccountDaoImplTraditional implements AccountDaoTraditional {
    @Autowired
    private QueryRunner queryRunner;
    @Autowired
    private ConnectionUtils connectionUtils;

    @Override
    public Account findByName(String name) {
        Account account = null;
        try {
            account = queryRunner.query(connectionUtils.getConnection(),
                    "select * from account where name=?", new BeanHandler<Account>
                            (Account.class), name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public void update(Account account) {
        try {
            queryRunner.update(connectionUtils.getConnection(),
                    "update account set balance=? where id=?", account.getBalance(),
                    account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}