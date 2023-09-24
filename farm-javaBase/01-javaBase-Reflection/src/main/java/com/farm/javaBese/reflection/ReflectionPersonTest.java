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
public class ReflectionPersonTest {
    @SneakyThrows
    public static void main(String[] args) {

        Class personClass = Class.forName("com.farm.javaBese.reflection.Person");


        System.out.println("全类名" + personClass.getName());

        System.out.println("简单类名" + personClass.getSimpleName());

        System.out.println("-----------------获取类及父类属性名称------------------------");

        Field[] fields = personClass.getFields();

        for (Field field : fields) {
            System.out.println("获取类及父类属性名称 " + field.getName());
        }

        System.out.println("---------------获取本类所有属性--------------------------");

        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println("获取本类所有属性 " + field.getName());
        }

        System.out.println("----------------获取类及父类所有公用的方法-------------------------");

        Method[] methods = personClass.getMethods();
        for(Method method : methods) {
            System.out.println("获取类及父类所有公用的方法 " + method.getName());
        }
        System.out.println("-----------------获取本类所有的方法------------------------");

        Method[] declaredMethods = personClass.getDeclaredMethods();
        for(Method method : declaredMethods){
            System.out.println("获取本类所有的方法 " + method.getName());
        }

        System.out.println("--------------获取本类的构造方法---------------------------");
        Constructor[] constructors = personClass.getConstructors();
        for(Constructor constructor : constructors){
            System.out.println("获取本类及父类的构造方法 " + constructor.getName());
        }

        System.out.println("--------------获取本类所有的构造方法---------------------------");
        Constructor[] declaredConstructors = personClass.getDeclaredConstructors();
        for(Constructor constructor : declaredConstructors){
            System.out.println("获取本类所有的构造方法 " + constructor.getName());
        }


        System.out.println("--------------父类class 对象superclass---------------------------");
        // 获取父类class
        Class superclass = personClass.getSuperclass();

        System.out.println("父类class 对象superclass" + superclass);

        System.out.println("----------------------获取类实现接口class对象---------------");
        Class[] interfaceList = personClass.getInterfaces();
        for(Class aInterface : interfaceList){
            System.out.println("获取类实现接口class对象 " + aInterface.getName());
        }

        System.out.println("----------------------本类注解信息---------------");
        Annotation[] annotations = personClass.getAnnotations();
        for (Annotation aAnnotation : annotations){
            System.out.println("本类注解信息 " + aAnnotation);
        }


    }
}
