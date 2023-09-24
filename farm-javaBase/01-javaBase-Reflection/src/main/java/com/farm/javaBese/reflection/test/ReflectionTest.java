package com.farm.javaBese.reflection.test;

import lombok.SneakyThrows;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author z2yEs
 * @create 11:43
 */
public class ReflectionTest {
    @SneakyThrows
    public static void main(String[] args) {
        Class<?> cls = Class.forName("com.farm.javaBese.reflection.test.PrivateTest");

        PrivateTest testObj = (PrivateTest)cls.newInstance();

        Field name = cls.getDeclaredField("name");
        name.setAccessible(true);
        name.set(testObj,"test2");

        Method getName = cls.getMethod("getName");
        System.out.println(getName.invoke(testObj));


        Class<?> fileClass = Class.forName("java.io.File");

        Constructor<?>[] declaredConstructors = fileClass.getDeclaredConstructors();

        for(Constructor<?> c : declaredConstructors){
            System.out.println(c.getName());
        }

        Constructor<?> declaredConstructor = fileClass.getDeclaredConstructor(String.class);
        File file = (File)declaredConstructor.newInstance("d:\\test.txt");
        file.createNewFile();

    }
}
