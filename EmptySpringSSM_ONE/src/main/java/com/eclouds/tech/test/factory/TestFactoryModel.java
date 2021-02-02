package com.eclouds.tech.test.factory;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 工厂模式实例化bean实体
 * @Author: xzj
 * @CreateDate: 2021/2/2 9:36
 */

/**
 * 优点：
 *  1 减轻了代码直接的耦合性
 *  2 保证了单例
 *  3 ioc的构建思想
 *  ioc后面加入了动态代理的：项目启动会将所有的类的字节码文件放到内存在，当需要用到某个类的时候再从内存中获取字节码文件通过反射实例化实体
 */
public class TestFactoryModel {

    public static final Map<String , Object> map = new HashMap();
    @Test
    public void test01() throws Exception{
        InputStream inputStream = TestFactoryModel.class.getClassLoader().getResourceAsStream("factory/factoryFile.xml");
        SAXReader reader = new SAXReader();
        Document read = reader.read(inputStream);
        Element rootElement = read.getRootElement();
        List<Element> bean = rootElement.elements("bean");
        for (Element element: bean) {
            TestBean testBean  = (TestBean)Class.forName(element.attributeValue("class")).newInstance();
            testBean.Perform();
            testBean.name = "222222";
            map.put(element.attributeValue("id"),testBean);
            test02();
        }
    }
    @Test
    public void test02() throws Exception {
        TestBean bean = (TestBean)map.get("TestBean");
        System.out.println("这是第二次获取"+bean.name);
    }

}
