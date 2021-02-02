package com.eclouds.tech.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class ConnectionUtils {
    //使Connection对象与当前线程绑定
    private ThreadLocal<Connection> tl = new ThreadLocal<>();
    @Autowired
    private DataSource dataSource;

    public Connection getConnection() {
        //从线程的局部变量中获取Connection对象
        Connection conn = tl.get();
        //如果没有获取到
        if (conn == null) {
            try {
                //从数据库连接池中获取一个Connection对象
                conn = dataSource.getConnection();
                //让Datasource对象与当前线程绑定
                tl.set(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    //让Connection对象与当前线程解绑
    public void remove() {
        tl.remove();
    }
}
