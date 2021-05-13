package com.ecloude.echo.xzj;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description: 启动类
 * @Author: xzj
 * @CreateDate: 2021/5/9 16:05
 */

/*使用 @NacosPropertySource 加载 dataId 为 example 的配置源，并开启自动更新：*/
@SpringBootApplication
@EnableDubbo
@NacosPropertySource(dataId = "mysql.properties" ,groupId = "dev")
@MapperScan("com.ecloude.echo.xzj.dao")
public class SpringBootApplicationClassByProvider {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationClassByProvider.class , args);
    }
}
