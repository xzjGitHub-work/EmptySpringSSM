package com.ecloude.echo.xzj.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ecloude.echo.xzj.bean.User;
import com.ecloude.echo.xzj.dao.UserMapper;
import com.ecloude.echo.xzj.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @Description: 作用描述
 * @Author: xzj
 * @CreateDate: 2021/5/10 10:03
 */
@Service
@Component
//@Service
public class TestServiceImpl implements TestService {
    @Autowired(required = false)
    private UserMapper userMapper;

    public String get() {
        System.out.println("访问到了");
        return "访问到了";
    }

    public List<Object> getAll() {
        return userMapper.getAllUser();

    }
}
