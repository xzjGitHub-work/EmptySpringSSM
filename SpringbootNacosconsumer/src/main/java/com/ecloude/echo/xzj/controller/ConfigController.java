package com.ecloude.echo.xzj.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.ecloude.echo.xzj.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("config")
public class ConfigController {

    @Reference
    private TestService testService;

    @NacosValue(value = "${dubbo.registry.address}")
    private String timeout;

    @RequestMapping("/get")
    public String get(){
        String s = testService.get();
        System.out.println(s);
        return s;
    }

    @RequestMapping("/getTime")
    public String getTime(){
        System.out.println(timeout);
        return timeout;
    }


    @RequestMapping("/getAll")
    public List<Object> getAll(){
        List<Object> all = testService.getAll();
        return all;
    }
}