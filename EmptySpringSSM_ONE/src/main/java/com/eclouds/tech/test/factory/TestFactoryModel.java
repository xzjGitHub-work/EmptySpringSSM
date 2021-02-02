package com.eclouds.tech.test.factory;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

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
    public static void main(String[] args) throws DocumentException {
        InputStream inputStream = TestFactoryModel.class.getClassLoader().getResourceAsStream("factory/factoryFile.xml");
        SAXReader reader = new SAXReader();
        Document read = reader.read(inputStream);
        Element rootElement = read.getRootElement();
        List<Element> bean = rootElement.elements("bean");
        for (Element element: bean) {
            System.out.println(element.attributeValue("class"));
//            Class.forName("")

        }
    }
}
