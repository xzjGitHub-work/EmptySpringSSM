package com.ecloude.echo.xzj.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("config")
public class ConfigController {

    @NacosValue(value = "${useLocalCache:xzjaaaaaa}", autoRefreshed = true)
    private String useLocalCache;

    @RequestMapping(value = "/get", method = GET)
    @ResponseBody
    public String get() {
        return useLocalCache;
    }
    @NacosValue(value = "${useLocalCache2}", autoRefreshed = true)
    private String useLocalCache2;

    @RequestMapping(value = "/get2", method = GET)
    @ResponseBody
    public String get2() {
        return useLocalCache2;
    }
}