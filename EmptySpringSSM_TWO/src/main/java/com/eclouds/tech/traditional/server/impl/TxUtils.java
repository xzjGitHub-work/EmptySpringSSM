package com.eclouds.tech.traditional.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class TxUtils {
    @Autowired
    private ConnectionUtils connectionUtils;

    //开启事务
    public void openTx() {
        try {
            connectionUtils.getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //提交事务
    public void commitTx() {
        try {
            connectionUtils.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //回滚事务
    public void rollbackTx() {
        try {
            connectionUtils.getConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //关闭事务
    public void closeTx() {
        try {
            connectionUtils.getConnection().close();
            connectionUtils.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}