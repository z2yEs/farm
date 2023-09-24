package com.farm.javaBese.reflection;

import lombok.SneakyThrows;

/**
 * @author z2yEs
 * @create 0:51
 * 类加载过程分析
 */
public class ClassLoad {
    @SneakyThrows
    public static void main(String[] args) {
        /**
         * 类加载过程
         * 1. 加载B类，生成B Class 对象
         * 2. 链接 num = 0;
         * 3. 初始化阶段
         *    依次自动收集静态变量于静态代码块
         *    clinit(){
         *         System.out.println("B 静态代码块执行");
         *         num = 300; // 合并
         *         num = 100;
         *    }
         */

        // System.out.println(B.num);

    }
}

class B {
    static {
        System.out.println("B 静态代码块执行");
        num = 300;
    }
    static int num = 100;

    B(){
        System.out.println("B 构造器执行");
    }
}
