package com.ecloude.echo.xzj.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 作用描述
 * @Author: xzj
 * @CreateDate: 2021/5/12 16:15
 */
@RestController
public class TestController {
    @NacosValue(value = "${dubbo.protocol.name}")
    private String name ;

    @RequestMapping("/get")
    public String get(){
        System.out.println(name);
        return name;
    }
}
