package com.ecloude.echo.xzj.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Description: 作用描述
 * @Author: xzj
 * @CreateDate: 2021/5/12 16:56
 */
@Getter
@Setter
public class User implements Serializable {
    String id;
    String account;
    String password;
    String name;
    String acount;


}
