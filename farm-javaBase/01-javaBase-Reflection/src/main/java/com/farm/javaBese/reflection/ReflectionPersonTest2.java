package com.farm.javaBese.reflection;

import lombok.SneakyThrows;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author z2yEs
 * @create 8:53
 */
public class ReflectionPersonTest2 {
    @SneakyThrows
    public static void main(String[] args) {

        Class personClass = Class.forName("com.farm.javaBese.reflection.Person");

        /**
         * 修饰符对应值
         * 默认修饰值：0，public修饰值 1 ,private 修饰值 2 ,
         * protected修饰值 4,static 8,
         * final修饰值 16
         * 组合 相加
         */
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println("本类中所有属性 " + field.getName()
            + "属性的修饰符值" + field.getModifiers()
            + "属性类型" + field.getType()
            );
        }

        Method[] declaredMethods = personClass.getDeclaredMethods();
        for(Method method : declaredMethods) {
            System.out.println("本类所有方法 "+ method.getName()
            + "方法返回Class对象" + method.getReturnType()
            + "方法修饰符值" + method.getModifiers()
            );
            // 方法形参返回
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class cls : parameterTypes){
                System.out.println(method.getName() + "形参" + cls.getName());
            }
        }

    }
}
