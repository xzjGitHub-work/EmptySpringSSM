package com.eclouds.tech.server.impl;

import com.eclouds.tech.server.UserService;
import org.springframework.stereotype.Service;

/**
 * @describe:实现类
 *
 * @author:xzj
 * @createDate:2021/2/2 15:43
 * @param:
 * @return:
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("保存成功了！");
    }

    @Override
    public Integer update() {
        System.out.println("更新成功了！");
        return 1;
    }

    @Override
    public Integer delete(Integer id) {
        System.out.println("删除成功了！" + id);
        return 1;
    }
}
