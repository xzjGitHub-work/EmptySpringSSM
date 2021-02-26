package com.tech.eclouds.xzj.test;

import com.tech.eclouds.xzj.pojo.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.InputStream;

/**
 * @Description: 作用描述
 * @Author: xzj
 * @CreateDate: 2021/2/26 14:17
 */
public class Demo01 {
    Logger logger = Logger.getLogger(Demo01.class);
    public SqlSession getSqlSession(String str){
        InputStream is = Demo01.class.getResourceAsStream(str);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //SqlSession用于CRUD的API主要有下面几个：
        //int insert(String statement, Object parameter) 新增
        //int update(String statement, Object parameter) 更新
        //int delete(String statement, Object parameter):删除
        //T selectOne(String statement, Object parameter):查询返回一条结果
        //List selectList(String statement, Object parameter):查询返回多条结果
        SqlSession session = factory.openSession();
        return session;
    }
    public UserModel getUserModel(){
        UserModel model = new UserModel();
        model.setName("许兆举");
        model.setAccount("10086");
        model.setPassword("password");
        return model;
    }
    /**
     * @describe:直接加载mapper执行sql
     *
     * @author:xzj
     * @createDate:2021/2/26 14:51
     * @param:[]
     * @return:void
     */
    @Test
    public void  test01(){
        SqlSession session = getSqlSession("/mybatiesConfigure.xml");
        session.insert("userMapper.saveUserModel",getUserModel());
        session.commit();
        session.close();
    }
    //com.tech.eclouds.xzj.dao.UserDao
    /**
     * @describe:添加mapper实现类
     *
     * @author:xzj
     * @createDate:2021/2/26 14:51
     * @param:[]
     * @return:void
     */
    @Test
    public void  test02(){
        SqlSession session = getSqlSession("/mybatiesConfigure.xml");
        session.insert("userDao.saveUserModel",getUserModel());
        session.commit();
        session.close();
    }
}
