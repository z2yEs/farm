package com.farm.javaBesee.reflection;

import lombok.SneakyThrows;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * java 反射测试
 * @author z2yEs
 * @create 23:07
 */
public class ReflectionTest {
    @SneakyThrows
    public static void main(String[] args) throws ClassNotFoundException {

        ReflectionTest reflectionTest = new ReflectionTest();
        /**
         * class 对象获取
         */
        reflectionTest.getClassFun();
        reflectionTest.getMethodFun();
        reflectionTest.getFieldFun();
        reflectionTest.getConstructorFun();

    }

    @SneakyThrows
    private void getConstructorFun(){
        Class employeeClass = Employee.class;
        Constructor constructor = employeeClass.getConstructor();
        System.out.println(constructor);

        Class employee2Class = Employee2.class;
        Constructor constructor1 = employee2Class.getConstructor(String.class);
        System.out.println(constructor1);

        Employee2 e2 = (Employee2)constructor1.newInstance("constructor1 test");
        System.out.println(e2.getName());



    }


    private void getMethodFun() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class employeeClass = Employee.class;
        Object o = employeeClass.newInstance();
        Method working = employeeClass.getMethod("working");
        working.invoke(o);
    }

    private void getFieldFun() throws Exception {
        Class employeeClass = Employee.class;
        Employee o = (Employee)employeeClass.newInstance();
        o.publicName = "test";

        Field publicName = employeeClass.getField("publicName");
        System.out.println(publicName.get(o));

    }

    /**
     * 获取Class 三种方式
     */
    private void getClassFun() throws ClassNotFoundException {
        Employee e = new Employee();
        e.setName("tom");
        Class aClass = e.getClass();
        String name = e.getClass().getName();
        String name1 = e.getName();

        System.out.println("aClass=" + aClass);
        System.out.println("name=" + name);
        System.out.println("name1=" + name1);

        Class<?> employee = Class.forName("com.farm.javaBesee.reflection.Employee");
        System.out.println(employee.getName());

        Class<Employee> employeeClass = Employee.class;
        System.out.println(employeeClass);

        System.out.println(Double[].class.getName());
        System.out.println(int[].class.getName());

    }
}
