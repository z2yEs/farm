package com.farm.javaBese.reflection;

import lombok.SneakyThrows;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author z2yEs
 * @create 8:53
 */
public class ReflectionCreatePerson {
    @SneakyThrows
    public static void main(String[] args) {

        Class personClass = Class.forName("com.farm.javaBese.reflection.Person");

        /**
         * 创建对象
         */
        Person person = (Person)personClass.newInstance();
        System.out.println("Person 实例" + person);
        /**
         * 有参构造器创建
         */
        Constructor constructor = personClass.getConstructor(String.class);
        Person person1 = (Person)constructor.newInstance("tom");
        System.out.println(person1.getName());

        Constructor constructor1 = personClass.getDeclaredConstructor(String.class, int.class);
        constructor1.setAccessible(true);
        Person person2 = (Person)constructor1.newInstance("jack", 18);
        System.out.println(person2);


    }
}
