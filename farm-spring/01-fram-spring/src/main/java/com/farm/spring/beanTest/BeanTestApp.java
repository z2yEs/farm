package com.farm.spring.beanTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.reflect.Field;
import java.util.Map;


@SpringBootApplication
public class BeanTestApp {

    private static final Logger log = LoggerFactory.getLogger(BeanTestApp.class);

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        /**
         * 1. BeanFactory 与 ApplicationContext 区别
         *
         */
        ConfigurableApplicationContext context = SpringApplication.run(BeanTestApp.class, args);

        // Object obj = context.getBean("objectName");

        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();

        /**
         *  2. BeanFactory 作用
         *     - getBean
         *     - 控制反转，依赖注入，Bean 生命周期 它的实现类进行提供 DefaultListableBeanFactory
         */

        Field singletonObjects = DefaultSingletonBeanRegistry.class.getDeclaredField("singletonObjects");
        singletonObjects.setAccessible(true);

        ConfigurableListableBeanFactory beanFactory1 = context.getBeanFactory();

        Map<String, Object> map = (Map<String, Object>) singletonObjects.get(beanFactory1);

        map.forEach((key, value) -> {
            System.out.println(key + " = " + value);
        });

        map.entrySet().stream().filter(item -> item.getKey().startsWith("component")).forEach(item -> {
            System.out.println("component" + item.getKey() + " = " + item.getValue());
        });

    }
}
