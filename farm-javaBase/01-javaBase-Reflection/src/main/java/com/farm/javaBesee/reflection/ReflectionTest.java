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
        System.out.println("-------------------getClassFun---------------------------");
        reflectionTest.getClassFun();
        System.out.println("-------------------getClassFun---------------------------");
        reflectionTest.getMethodFun();
        System.out.println("-------------------getMethodFun---------------------------");
        reflectionTest.getFieldFun();
        System.out.println("-------------------getFieldFun---------------------------");
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
    @SneakyThrows
    private void getClassFun() throws ClassNotFoundException {


        /**
         * 编译阶段获取Class，多用于配置文件，读取类全路径，加载类
         */
        Class<?> employee = Class.forName("com.farm.javaBesee.reflection.Employee");

        System.out.println(employee);
        // 获取运行类型
        Class<? extends Class> aClass1 = employee.getClass();
        System.out.println(aClass1);
        // 获取全类名
        System.out.println(employee.getName());
        // 获取包名称
        System.out.println(employee.getPackage().getName());
        // 实列化
        Employee employeeObj = (Employee)employee.newInstance();
        employeeObj.publicName = "employeeObj publicName";
        // 获取属性
        Field publicName = employee.getField("publicName");
        System.out.println(publicName);
        publicName.set(employeeObj,"修改 employeeObj publicName");
        System.out.println(publicName.get(employeeObj));


        /**
         * 类名加载class,多用于参数传递
         */
        Class<Employee> employeeClass = Employee.class;
        System.out.println(employeeClass);


        /**
         * 对象获取，多用于有对象实列
         */
        Employee e = new Employee();
        e.setName("tom");
        Class aClass = e.getClass();
        String name = e.getClass().getName();
        String name1 = e.getName();

        System.out.println("aClass=" + aClass);
        System.out.println("name=" + name);
        System.out.println("name1=" + name1);

        /**
         * 类加载器获取,根据已知类获取公用类加载器，去加载配置文件下的类
         */
        Employee employee4 = new Employee();
        ClassLoader classLoader = employee4.getClass().getClassLoader();
        Class<?> aClass2 = classLoader.loadClass("com.farm.javaBesee.reflection.Employee2");
        System.out.println(aClass2);

        // 基本数据类型
        System.out.println(int.class);

        // 基本类型包装类,获取Class
        System.out.println(Integer.TYPE);


    }
}
