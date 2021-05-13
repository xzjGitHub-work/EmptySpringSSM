package com.ecloude.echo.xzj.dao;

import com.ecloude.echo.xzj.bean.User;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UserMapper {
    List<Object> getAllUser();

    Integer addUser(User user);

    Integer updateUserById(User user);

    Integer deleteUserById(Integer id);
}