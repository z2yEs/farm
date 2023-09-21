package com.farm.javaBesee.reflection;

import java.io.Serializable;

/**
 * @author z2yEs
 * @create 0:06
 *
 *
 */
public class AllTypeClass {
    public static void main(String[] args) {
        // 外部类
        System.out.println(String.class);
        // 接口
        System.out.println(Serializable.class);
        // 数组
        System.out.println(Integer[].class);
        // 二维数组
        System.out.println(Integer[][].class);
        // 注解
        System.out.println(Deprecated.class);
        // 枚举
        System.out.println(Thread.State.class);
        // 基本数据类型
        System.out.println(int.class);
        // 包装类
        System.out.println(Integer.class);
        // void
        System.out.println(void.class);
        // class
        System.out.println(Class.class);
    }
}
