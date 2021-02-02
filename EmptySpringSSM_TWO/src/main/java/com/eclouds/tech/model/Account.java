package com.eclouds.tech.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 余额
     */
    private Double balance;
}