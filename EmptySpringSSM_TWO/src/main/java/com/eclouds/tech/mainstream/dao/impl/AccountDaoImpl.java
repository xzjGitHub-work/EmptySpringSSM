package com.eclouds.tech.mainstream.dao.impl;

import com.eclouds.tech.mainstream.dao.AccountDao;
import com.eclouds.tech.model.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

/**
 * @describe:实现类
 * @author:xzj
 * @createDate:2021/2/2 11:10
 * @param:
 * @return:
 */
@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private QueryRunner queryRunner;

    @Override
    public Account findByName(String name) {
        Account account = null;
        try {
            account = queryRunner.query("select * from account where name = ? ", new
                    BeanHandler<>(Account.class), name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public void update(Account account) {
        try {
            queryRunner.update("update account set balance = ? where id=?", account.getBalance(),
                    account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
