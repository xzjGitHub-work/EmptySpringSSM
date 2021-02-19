package com.eclouds.tech.xzj.controller;


import com.eclouds.tech.xzj.dao.Person;
import ognl.Node;
import ognl.Ognl;
import ognl.OgnlParser;

import java.io.StringReader;

/**
 * @Description: 作用描述
 * @Author: xzj
 * @CreateDate: 2021/2/8 9:24
 */
public class ServletController  {
    public static void main(String[] args) throws Exception {
        String expression = "age != ''";
        Node node = new OgnlParser(new StringReader(expression)).topLevelExpression();
        Person person = new Person();
        person.setAge(0);
        Object value = Ognl.getValue(node, person);
        System.out.println(value);
    }
}
